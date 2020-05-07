package com.example.demo.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.Model.Category
import com.example.demo.Model.CategoryAdapter
import com.example.demo.Services.CategoryService
import com.example.demo.R
import kotlinx.android.synthetic.main.json_fragment.*

class JSONFragment: Fragment() {
    var categories = ArrayList<Category>()
    private lateinit var categoiesAdapter : CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.json_fragment,container,false)
    }


    override fun onStart() {
        super.onStart()
        val listener = object : categoriesDL {
            override fun success(success: Boolean?) {
                initReciclerView()
                categoiesAdapter.submitList(categories)
                Log.i("Final", categories.toString())
            }
        }
        categories = CategoryService.getInstance().getCategories(context,listener)
    }

    interface categoriesDL {
        fun success(success: Boolean?)
    }

    private  fun initReciclerView(){
        categories_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            categoiesAdapter = CategoryAdapter()
            adapter = categoiesAdapter
        }
    }
}