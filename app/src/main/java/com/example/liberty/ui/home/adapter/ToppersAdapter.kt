package com.example.liberty.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.network.response.TopersData

class ToppersAdapter(private val context: Context,private var listData: ArrayList<TopersData>) :
    RecyclerView.Adapter<ToppersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgToppers: ImageView = itemView.findViewById(R.id.img_topper)
        var tvTopperName: TextView = itemView.findViewById(R.id.tv_name_topper)
        var tvTopperClass: TextView = itemView.findViewById(R.id.tv_class_topper)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_toppers, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listData[position]

       Glide.with(context).load(itemList.image).into(holder.imgToppers)
        holder.tvTopperName.text = itemList.name
        holder.tvTopperClass.text =itemList.courseName
    }

    fun setData(itemList: List<TopersData>){
        this.listData = itemList as ArrayList<TopersData>
        notifyDataSetChanged()
    }

}