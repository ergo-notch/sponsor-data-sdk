package com.example.demo.Model

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import kotlinx.android.synthetic.main.category_detail.view.*

class CategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Category> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_detail,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CategoryHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    fun submitList(categories : List<Category>){
        items = categories
    }

    class CategoryHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val text = itemView.cardview_name_txt

        fun bind(category: Category){
            text.setText(category.name)
        }
    }
}