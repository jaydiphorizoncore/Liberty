package com.example.liberty.ui.dashboard.home.courses.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.Course

class CoursesAdapter(private var context: Context, private var listData: ArrayList<Course>) :
    RecyclerView.Adapter<CoursesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_popular_courses = itemView.findViewById<TextView>(R.id.tv_popular_courses)
        var img_dp_courses: ImageView = itemView.findViewById(R.id.img_dp_courses)
        var tv_amount_courses: TextView = itemView.findViewById(R.id.tv_amount_courses)
        var tv_GCERT_courses: TextView = itemView.findViewById(R.id.tv_GCERT_courses)
        var tv_video_courses: TextView = itemView.findViewById(R.id.tv_video_courses)
        var tv_materials_courses: TextView = itemView.findViewById(R.id.tv_materials_courses)
        // var tv_tests_courses: TextView = itemView.findViewById(R.id.tv_tests_courses)
        //  var item_courses_ll: ConstraintLayout = itemView.findViewById(R.id.item_courses_ll)

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
        val listDAta = listData[position]

        holder.tv_popular_courses.text = listDAta.isCourseLabel
        Glide.with(context).load(R.drawable.ic_course_dp).into(holder.img_dp_courses)
        holder.tv_amount_courses.text = listDAta.finalAmountLabel
        holder.tv_GCERT_courses.text = listDAta.name
        holder.tv_video_courses.text = listDAta.labelTotalVideos
        holder.tv_materials_courses.text = listDAta.labelTotalMaterials
        //   holder.tv_tests_courses.text =
        //  holder.item_courses_ll.setBackgroundColor(listData[position].item_courses_ll)
    }

    fun setAllData(itemList: List<Course>) {
        this.listData = itemList as ArrayList<Course>
        notifyDataSetChanged()
    }

}