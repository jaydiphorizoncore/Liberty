package com.example.liberty.ui.dashboard.home.toppers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.TopersData
import com.example.liberty.databinding.ItemToppersBinding

class ToppersAdapter(private val context: Context, private var listData: List<TopersData>) :
    RecyclerView.Adapter<ToppersAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemToppersBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemToppersBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listData[position]

        Glide.with(context).load(itemList.image).into(holder.binding.imgTopper)
        holder.binding.tvNameTopper.text = itemList.name
        holder.binding.tvClassTopper.text = itemList.courseName
    }

    fun setData(itemList: List<TopersData>) {
        this.listData = itemList as ArrayList<TopersData>
        notifyDataSetChanged()
    }
}