package com.example.liberty.ui.dashboard.home.quiz.quizdetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.ActivityDailyQuizBinding

class DailyQuizActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDailyQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_daily_quiz)
    }
}