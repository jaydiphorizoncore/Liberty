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
import com.example.liberty.databinding.ItemTestimonialBinding

class TestimonialAdapter(
    private val context: Context,
    private var listData: List<TestimonialsData>
) :
    RecyclerView.Adapter<TestimonialAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemTestimonialBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTestimonialBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData = listData[position]

        Glide.with(context).load(listData.largeImageUrl).into(holder.binding.imgTestimonial)
        holder.binding.tvNameTestimonial.text = listData.name
        holder.binding.tvDescTestimonial.text = listData.message
        holder.binding.tvReadMore.text = "Read More"
        holder.binding.tvReadMore.setOnClickListener {

        }
    }

    fun setData(itemList: List<TestimonialsData>) {
        this.listData = itemList as ArrayList<TestimonialsData>
        notifyDataSetChanged()
    }
}