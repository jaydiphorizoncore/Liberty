package com.example.liberty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.home.dataclass.CategoryData

class CategoryAdapter(private val listData: ArrayList<CategoryData>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgCategory: ImageView = itemView.findViewById(R.id.img_category_item)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_category_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCategory.setImageResource(listData[position].img_category)
        holder.tvCategory.text = listData[position].tv_category
    }
}