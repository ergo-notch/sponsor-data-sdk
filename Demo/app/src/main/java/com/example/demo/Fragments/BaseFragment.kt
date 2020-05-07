package com.example.demo.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.demo.R

class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.base_fragment,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val webview = this.view?.findViewById<TextView>(R.id.webview_text)
        val json = this.view?.findViewById<TextView>(R.id.json_text)

        webview?.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frag_contaainer, WebViewFragment())?.addToBackStack(null)?.commit()
        }
        json?.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frag_contaainer, JSONFragment())?.addToBackStack(null)?.commit()
        }
    }
}