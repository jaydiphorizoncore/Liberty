package com.example.liberty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.home.dataclass.CoursesData

class CoursesAdapter(val listData: ArrayList<CoursesData>) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_popular_courses = itemView.findViewById<TextView>(R.id.tv_popular_courses)
        var img_dp_courses: ImageView = itemView.findViewById(R.id.img_dp_courses)
        var tv_amount_courses: TextView = itemView.findViewById(R.id.tv_amount_courses)
        var tv_GCERT_courses: TextView = itemView.findViewById(R.id.tv_GCERT_courses)
        var tv_video_courses: TextView = itemView.findViewById(R.id.tv_video_courses)
        var tv_materials_courses: TextView = itemView.findViewById(R.id.tv_materials_courses)
        var tv_tests_courses: TextView = itemView.findViewById(R.id.tv_tests_courses)
        var item_courses_ll: ConstraintLayout = itemView.findViewById(R.id.item_courses_ll)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_courses, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_popular_courses.text = listData[position].tv_popular_courses
        holder.img_dp_courses.setImageResource(listData[position].img_dp_courses)
        holder.tv_amount_courses.text = listData[position].tv_amount_courses
        holder.tv_GCERT_courses.text = listData[position].tv_GCERT_courses
        holder.tv_video_courses.text = listData[position].tv_video_courses
        holder.tv_materials_courses.text = listData[position].tv_materials_courses
        holder.tv_tests_courses.text = listData[position].tv_tests_courses
        holder.item_courses_ll.setBackgroundColor(listData[position].item_courses_ll)
    }
}