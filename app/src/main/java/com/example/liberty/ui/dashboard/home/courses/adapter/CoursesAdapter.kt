package com.example.liberty.ui.dashboard.home.courses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.Course
import com.example.liberty.databinding.ItemCoursesBinding

class CoursesAdapter(private var context: Context, private var listData: List<Course>) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCoursesBinding) : RecyclerView.ViewHolder(binding.root) {

        // var tv_tests_courses: TextView = itemView.findViewById(R.id.tv_tests_courses)
        //  var item_courses_ll: ConstraintLayout = itemView.findViewById(R.id.item_courses_ll)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCoursesBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listDAta = listData[position]

        holder.binding.tvPopularCourses.text = listDAta.isCourseLabel
        Glide.with(context).load(R.drawable.ic_course_dp).into(holder.binding.imgDpCourses)
        holder.binding.tvAmountCourses.text = listDAta.finalAmountLabel
        holder.binding.tvGCERTCourses.text = listDAta.name
        holder.binding.tvVideoCourses.text = listDAta.labelTotalVideos
        holder.binding.tvMaterialsCourses.text = listDAta.labelTotalMaterials
        //   holder.tv_tests_courses.text =
        //  holder.item_courses_ll.setBackgroundColor(listData[position].item_courses_ll)
    }

}