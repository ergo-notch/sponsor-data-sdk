package com.example.demo.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.demo.R
import com.example.demo.Utils.Constants
import com.example.sponsordata.EncapURL
import kotlinx.android.synthetic.main.webview_fragment.*

class WebViewFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.webview_fragment, container,false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val encapURL = EncapURL(Constants.DATA_SPONSOR_KEY)

        var url = "http://200.57.179.163:3008/api/user"

        ////////////////////////////////////////////////////////////////////////////////////////
        val requestQueue = Volley.newRequestQueue(context, encapURL)
        val webView = this.view?.findViewById<WebView>(R.id.webview)
        webview.getSettings().setJavaScriptEnabled(true)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                try {

                    webView?.webViewClient = object :  WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                            view?.loadUrl(url)
                            return true
                        }
                    }

                    Log.i("Tag",response)
                    webview.loadDataWithBaseURL("", response, "text/html", "UTF-8", "");
                }catch (e : Error){
                    Log.i("Error",e.localizedMessage + "  " + e.toString())
                }
            },
            Response.ErrorListener {  })

        requestQueue.add(stringRequest)

    }
}