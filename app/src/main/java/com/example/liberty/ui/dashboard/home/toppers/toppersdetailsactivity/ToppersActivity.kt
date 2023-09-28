package com.example.liberty.ui.dashboard.home.toppers.toppersdetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.ActivityToppersBinding

class ToppersActivity : AppCompatActivity() {
    private lateinit var binding:ActivityToppersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_toppers)
    }
}