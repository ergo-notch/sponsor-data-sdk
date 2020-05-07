package com.example.demo.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demo.Fragments.BaseFragment
import com.example.demo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.frag_contaainer, BaseFragment()).commit()


        }
    }

//    fun onSNACK(view: View){
//        //Snackbar(view)
//        val snackbar = Snackbar.make(view, "Datos sponsoreados",
//            Snackbar.LENGTH_LONG).setAction("Action", null)
//        snackbar.setActionTextColor(Color.BLUE)
//        val snackbarView = snackbar.view
//        snackbarView.setBackgroundColor(Color.LTGRAY)
//        val textView =
//            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
//        textView.setTextColor(Color.BLUE)
//        textView.textSize = 28f
//        snackbar.show()
//    }
