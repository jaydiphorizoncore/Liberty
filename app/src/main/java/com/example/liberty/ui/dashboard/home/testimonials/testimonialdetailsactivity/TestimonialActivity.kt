package com.example.liberty.ui.dashboard.home.testimonials.testimonialdetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.ActivityTestimonialBinding

class TestimonialActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTestimonialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_testimonial)
    }
}