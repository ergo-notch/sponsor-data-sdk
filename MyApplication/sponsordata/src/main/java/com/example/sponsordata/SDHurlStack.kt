package com.example.sponsordata

import android.util.Log
import com.android.volley.toolbox.HurlStack
import java.io.IOException
import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL

class SDHurlStack(val sdApikey: String) : HurlStack() {
    private val PROXY_ADDRESS = "129.213.197.134"
    private val PROXY_PORT = 8082


    @Throws(IOException::class)
    override fun createConnection(url: URL): HttpURLConnection? {
        val proxy = Proxy(
            Proxy.Type.HTTP,
            InetSocketAddress.createUnresolved(PROXY_ADDRESS, PROXY_PORT)
        )

        Log.i("URL", url.toString())

        val conn = URL(url.toString())
        val httpURLConnection = conn.openConnection(proxy) as HttpURLConnection
        httpURLConnection.setRequestProperty("Proxy-Authorization", sdApikey)
        Log.i("Response", httpURLConnection.toString())

        return httpURLConnection
    }
}