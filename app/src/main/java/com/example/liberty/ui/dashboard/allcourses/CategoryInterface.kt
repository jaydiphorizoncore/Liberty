package com.example.liberty.ui.dashboard.allcourses

import com.example.liberty.data.network.response.categorydetailsresponse.CategoryDetailsResponse

interface CategoryInterface {
    fun onStarted()
    fun onFailure(message: String)
    fun onSuccess(response: CategoryDetailsResponse)
}