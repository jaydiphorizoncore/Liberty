package com.example.liberty.ui.dashboard.home.packages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.dashboard.home.packages.model.PackageData

class PackageAdapter(private val listData: ArrayList<PackageData>) :
    RecyclerView.Adapter<PackageAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_top_selling = itemView.findViewById<TextView?>(R.id.tv_topSeling)
        var tv_name = itemView.findViewById<TextView?>(R.id.tv_GCERT)
        var tv_subject = itemView.findViewById<TextView?>(R.id.tv_subject)
        var tv_materials = itemView.findViewById<TextView?>(R.id.tv_materials)
        var tv_tests = itemView.findViewById<TextView?>(R.id.tv_tests)
        var tv_only = itemView.findViewById<TextView?>(R.id.tv_only)
        var tv_video = itemView.findViewById<TextView?>(R.id.tv_video)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_packages, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_top_selling.text = listData[position].tv_top_selling
        holder.tv_name.text = listData[position].tv_name
        holder.tv_subject.text = listData[position].tv_subject
        holder.tv_materials.text = listData[position].tv_materials
        holder.tv_video.text = listData[position].tv_video
        holder.tv_tests.text = listData[position].tv_tests
        holder.tv_only.text = listData[position].tv_only
    }
}