package com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.R
import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.network.response.coursesdetailsresponse.CoursesDetailsResponse
import com.example.liberty.data.network.response.coursesdetailsresponse.TagwiseData
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.databinding.ActivityCoursesBinding
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.viewmodel.CoursesDetailsViewModel
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.viewmodel.CoursesDetailsViewModelFectory
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.adapter.CoursesDetailsAdapter

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
        Log.d("onStarted", "onStartedCourses")
        binding.progressCoursesDetailsActivity.visibility = View.VISIBLE
    }

    override fun onSuccess(response: CoursesDetailsResponse) {
        binding.progressCoursesDetailsActivity.visibility = View.GONE
        Log.d("onSuccess", "$response")

        if (response.data.tagwiseData.isNullOrEmpty()) {
            binding.coursesDetailsRecyclerView.visibility = View.GONE
            binding.tvIsCoursesDataNotFound.visibility = View.VISIBLE
        } else {
            coursesDetailsAdapter = CoursesDetailsAdapter(this, response.data.tagwiseData)
            binding.coursesDetailsRecyclerView.adapter = coursesDetailsAdapter
        }

        val searchList = response.data.tagwiseData
        setSearchView(searchList)

    }

    private fun setSearchView(searchList: List<TagwiseData>?) {
        binding.coursesSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filterName = searchList!!.filter { name ->
                    name.name.contains(newText!!, true)
                }
                coursesDetailsAdapter = CoursesDetailsAdapter(this@CoursesActivity, filterName)
                coursesDetailsAdapter.notifyDataSetChanged()
                binding.coursesDetailsRecyclerView.adapter = coursesDetailsAdapter

                // Show/hide the "not found" message
                if (filterName.isEmpty()) {
                    binding.tvIsCoursesDataNotFound.visibility = View.VISIBLE
                } else {
                    binding.tvIsCoursesDataNotFound.visibility = View.GONE
                }
                return true
            }
        })
    }

    override fun onFailure(message: String) {
        binding.progressCoursesDetailsActivity.visibility = View.GONE
        Log.e("onFailure", message)
    }
}