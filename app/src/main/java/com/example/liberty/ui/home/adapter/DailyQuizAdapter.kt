package com.example.liberty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.liberty.R
import com.example.liberty.ui.home.dataclass.DailyQuizData

class DailyQuizAdapter(var listData: ArrayList<DailyQuizData>) :
    RecyclerView.Adapter<DailyQuizAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_dailyQuizName:TextView = itemView.findViewById(R.id.tv_dailyQuizName)
        var tv_questions:TextView = itemView.findViewById(R.id.tv_questions)
        var tv_time:TextView = itemView.findViewById(R.id.tv_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_daily_quiz,parent,false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_dailyQuizName.text = listData[position].tv_dailyQuizName
        holder.tv_questions.text =listData[position].tv_questions.toString() + " Questions"
        holder.tv_time.text = listData[position].tv_time.toString() + " Minutes"
    }
}