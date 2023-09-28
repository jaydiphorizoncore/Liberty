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

class DailyQuizAdapter(private var context: Context, private var listData: ArrayList<Test>) :
    RecyclerView.Adapter<DailyQuizAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemDailyQuizBinding) : RecyclerView.ViewHolder(binding.root) {

        var tv_dailyQuizName: TextView = itemView.findViewById(R.id.tv_dailyQuizName)
        var tv_questions: TextView = itemView.findViewById(R.id.tv_questions)
        var tv_time: TextView = itemView.findViewById(R.id.tv_time)

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

    fun setData(itemList: List<Test>) {
        this.listData = itemList as ArrayList<Test>
        notifyDataSetChanged()
    }
}