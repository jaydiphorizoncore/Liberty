package com.example.liberty.ui.dashboard.home.packages.packagedetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.ActivityCoursesBinding
import com.example.liberty.databinding.ActivityPackageBinding

class PackageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPackageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_package)
    }
}