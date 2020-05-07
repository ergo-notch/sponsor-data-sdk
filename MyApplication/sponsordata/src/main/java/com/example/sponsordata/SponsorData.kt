package com.example.sponsordata

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BaseHttpStack
import com.android.volley.toolbox.Volley


class SponsorData {

    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @param stack A {@link BaseHttpStack} to use for the network, or null for default.
     * @return A started {@link RequestQueue} instance.
     */
    companion object {
        private const val KEY = "com.sponsor.data.v1.API_KEY"

        /** Default on-disk cache directory.  */
        private const val DEFAULT_CACHE_DIR = "sponsor.data"

        fun newRequestQueue(context: Context, stack: BaseHttpStack?): RequestQueue {
            val ai: ApplicationInfo =
                context.packageManager.getApplicationInfo(
                    context.packageName,
                    PackageManager.GET_META_DATA
                )
            val apiKey = ai.metaData.getString(KEY)
            return if(stack != null){
                Volley.newRequestQueue(context,stack)
            }else{
                Volley.newRequestQueue(context, SDHurlStack(apiKey))
            }
        }

        /**
         * Creates a default instance of the worker pool and calls [RequestQueue.start] on it.
         *
         * @param context A [Context] to use for creating the cache dir.
         * @return A started [RequestQueue] instance.
         */
        fun newRequestQueue(context: Context): RequestQueue? {
            val ai: ApplicationInfo =
                context.packageManager.getApplicationInfo(
                    context.packageName,
                    PackageManager.GET_META_DATA
                )
            val apiKey = ai.metaData.getString(KEY)

            return Volley.newRequestQueue(context, SDHurlStack(apiKey))
        }
    }
}

