package com.example.liberty.ui.dashboard.allcourses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.categorydetailsresponse.Course
import com.example.liberty.databinding.ItemCategoryDetailsBinding

class AllCategoryAdapter(
    private var context: Context,
    private var listData: List<Course>
) :
    RecyclerView.Adapter<AllCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemCategoryDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCategoryDetailsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = listData[position]

        holder.binding.tvPopularCategoryDetails.text = itemData.isCourseLabel
        Glide.with(context).load(R.drawable.ic_course_dp).into(holder.binding.imgDpCategoryDetails)
        holder.binding.tvAmountCategoryDetails.text = itemData.finalAmountLabel
        holder.binding.tvGCERTCategoryDetails.text = itemData.name
        holder.binding.tvVideoCategoryDetails.text = itemData.labelTotalVideos
        holder.binding.tvMaterialsCategoryDetails.text = itemData.labelTotalMaterials

    }
}
