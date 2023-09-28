package com.example.liberty.ui.dashboard.home.category.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.Category
import com.example.liberty.databinding.ItemCategoryBinding

class CategoryAdapter(private val context: Context, private var listData: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            // LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData = listData[position]

        Glide.with(context).load(listData.iconUrl).into(holder.binding.imgCategoryItem)
        holder.binding.tvCategoryItem.text = listData.title
    }

    fun setData(itemList: List<Category>) {
        this.listData = itemList as ArrayList<Category>
        notifyDataSetChanged()
    }

}