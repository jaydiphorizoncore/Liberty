package com.example.liberty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.home.dataclass.ToppersData

class ToppersAdapter(var listData: ArrayList<ToppersData>) :
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
        holder.imgToppers.setImageResource(listData[position].imgToppers)
        holder.tvTopperName.text = listData[position].tvToppersName
        holder.tvTopperClass.text = listData[position].tvToppersClass
    }
}