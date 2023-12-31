package com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity

import com.example.liberty.data.network.response.coursesdetailsresponse.CoursesDetailsResponse

interface CoursesDetailsInterface {
    fun onStarted()
    fun onSuccess(response: CoursesDetailsResponse)
    fun onFailure(message: String)
}