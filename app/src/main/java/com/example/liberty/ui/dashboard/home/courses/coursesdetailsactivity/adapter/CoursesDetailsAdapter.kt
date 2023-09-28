package com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.coursesdetailsresponse.TagwiseData
import com.example.liberty.databinding.ItemCoursesDetailsBinding

class CoursesDetailsAdapter(
    private var context: Context,
    private var listData: List<TagwiseData>
) :
    RecyclerView.Adapter<CoursesDetailsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemCoursesDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCoursesDetailsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = listData[position]

        holder.binding.tvPopularCoursesDetails.text = itemData.isCourseLabel
        Glide.with(context).load(R.drawable.ic_course_dp).into(holder.binding.imgDpCoursesDetails)
        holder.binding.tvAmountCoursesDetails.text = itemData.finalAmountLabel
        holder.binding.tvGCERTCoursesDetails.text = itemData.name
        holder.binding.tvVideoCoursesDetails.text = itemData.labelTotalVideos
        holder.binding.tvMaterialsCoursesDetails.text = itemData.labelTotalMaterials

    }

   /* fun setData(itemList: List<TagwiseData>) {
        this.listData = itemList as ArrayList<TagwiseData>
        notifyDataSetChanged()
    }*/
}