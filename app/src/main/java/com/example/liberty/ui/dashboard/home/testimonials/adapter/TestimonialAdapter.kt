package com.example.liberty.ui.dashboard.home.testimonials.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.TestimonialsData

class TestimonialAdapter(
    private val context: Context,
    private var listData: ArrayList<TestimonialsData>
) :
    RecyclerView.Adapter<TestimonialAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgTestimonial: ImageView = itemView.findViewById(R.id.img_testimonial)
        var tvNameTestimonial: TextView = itemView.findViewById(R.id.tv_name_testimonial)
        var tvDescTestimonial: TextView = itemView.findViewById(R.id.tv_desc_testimonial)
        var tvReadMore: TextView = itemView.findViewById(R.id.tvReadMore)

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
        val listData = listData[position]

        Glide.with(context).load(listData.largeImageUrl).into(holder.imgTestimonial)
        holder.tvNameTestimonial.text = listData.name
        holder.tvDescTestimonial.text = listData.message
        holder.tvReadMore.text = "Read More"
        holder.tvReadMore.setOnClickListener {

        }
    }

    fun setData(itemList: List<TestimonialsData>) {
        this.listData = itemList as ArrayList<TestimonialsData>
        notifyDataSetChanged()
    }


}