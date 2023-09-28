package com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.R
import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.network.response.coursesdetailsresponse.CoursesDetailsResponse
import com.example.liberty.data.network.response.coursesdetailsresponse.TagwiseData
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.databinding.ActivityCoursesBinding
import com.example.liberty.ui.dashboard.home.category.categorydetailsactivity.CoursesDetailsInterface
import com.example.liberty.ui.dashboard.home.category.categorydetailsactivity.viewmodel.CoursesDetailsViewModel
import com.example.liberty.ui.dashboard.home.category.categorydetailsactivity.viewmodel.CoursesDetailsViewModelFectory
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.adapter.CoursesDetailsAdapter
import com.example.liberty.util.toast

class CoursesActivity : AppCompatActivity(), CoursesDetailsInterface {
    private lateinit var binding: ActivityCoursesBinding
    private lateinit var viewModel: CoursesDetailsViewModel
    private lateinit var coursesDetailsAdapter: CoursesDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_courses)


        val api = ApiInterface()
        val repository = ApiRepository(api)
        val factory = CoursesDetailsViewModelFectory(repository)
        viewModel = ViewModelProvider(this, factory)[CoursesDetailsViewModel::class.java]
        viewModel.coursesDetailsInterface = this
        viewModel.getCoursesDetails()

    }


    override fun onStarted() {
        Log.d("TAG", "onStartedCourses")
        binding.progressCoursesDetailsActivity.visibility = View.VISIBLE
    }

    override fun onSuccess(response: CoursesDetailsResponse) {
        binding.progressCoursesDetailsActivity.visibility = View.GONE
        Log.d("TAG", "Success")
        coursesDetailsAdapter = CoursesDetailsAdapter(this, response.data.tagwiseData)
        binding.coursesDetailsRecyclerView.adapter = coursesDetailsAdapter
    }

    override fun onFailure(message: String) {
        binding.progressCoursesDetailsActivity.visibility = View.GONE
        Log.e("onFailure", message)
    }
}