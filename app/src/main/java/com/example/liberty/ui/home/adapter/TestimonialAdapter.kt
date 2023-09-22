package com.example.liberty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.home.dataclass.TestimonialData

class TestimonialAdapter(var listData: ArrayList<TestimonialData>) :
    RecyclerView.Adapter<TestimonialAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgTestimonial: ImageView = itemView.findViewById(R.id.img_testimonial)
        var tvNameTestimonial: TextView = itemView.findViewById(R.id.tv_name_testimonial)
        var tvDescTestimonial: TextView = itemView.findViewById(R.id.tv_desc_testimonial)
        var tvReadMore :TextView = itemView.findViewById(R.id.tvReadMore)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_testimonial, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgTestimonial.setImageResource(listData[position].img_testimonial)
        holder.tvNameTestimonial.text = listData[position].tv_name_testimonial
        holder.tvDescTestimonial.text = listData[position].tv_desc_testimonial
        holder.tvReadMore.text = "Read More"
    }
}