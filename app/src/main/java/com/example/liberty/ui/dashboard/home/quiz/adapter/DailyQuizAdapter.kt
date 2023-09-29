package com.example.liberty.ui.dashboard.home.quiz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.data.network.response.dashboardresponse.Test
import com.example.liberty.databinding.ItemCategoryBinding
import com.example.liberty.databinding.ItemDailyQuizBinding

class DailyQuizAdapter(private var context: Context, private var listData: List<Test>) :
    RecyclerView.Adapter<DailyQuizAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemDailyQuizBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDailyQuizBinding.inflate(LayoutInflater.from(parent.context))
        )

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData = listData[position]

        holder.binding.tvDailyQuizName.text = listData.testTitle
        holder.binding.tvQuestions.text = listData.questions
        holder.binding.tvTime.text = listData.duration
    }

}