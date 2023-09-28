package com.example.liberty.ui.dashboard.home.packages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.databinding.ItemCategoryBinding
import com.example.liberty.databinding.ItemPackagesBinding
import com.example.liberty.ui.dashboard.home.packages.model.PackageData

class PackageAdapter(private val listData: ArrayList<PackageData>) :
    RecyclerView.Adapter<PackageAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemPackagesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPackagesBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTopSeling.text = listData[position].tv_top_selling
        holder.binding.tvGCERT.text = listData[position].tv_name
        holder.binding.tvSubject.text = listData[position].tv_subject
        holder.binding.tvMaterials.text = listData[position].tv_materials
        holder.binding.tvVideo.text = listData[position].tv_video
        holder.binding.tvTests.text = listData[position].tv_tests
        holder.binding.tvOnly.text = listData[position].tv_only
    }
}