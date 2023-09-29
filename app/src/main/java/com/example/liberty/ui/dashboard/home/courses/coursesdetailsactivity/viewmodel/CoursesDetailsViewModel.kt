package com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.liberty.data.network.request.coursesdetailsrequest.CoursesDetailsRequest
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.ui.dashboard.home.HomeFragment.Companion.i
import com.example.liberty.ui.dashboard.home.courses.coursesdetailsactivity.CoursesDetailsInterface
import com.example.liberty.util.ApiException
import com.example.liberty.util.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoursesDetailsViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    lateinit var coursesDetailsInterface: CoursesDetailsInterface
    private var isCourses = i

    fun getCoursesDetails() {
        coursesDetailsInterface.onStarted()

        CoroutineScope(Dispatchers.Main).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token


            val coursesDetailsRequest = CoursesDetailsRequest(
                memberId = "1563",
                type = "0",
                isCourse = isCourses,
                langCode = "en",
                deviceType = 1,
                deviceVersion = "1.0",
                appVersion = "1.3.8"
            )
            try {

                val response = apiRepository.getCoursesDetails(headers, coursesDetailsRequest)
                Log.d("TAG", "response: $response")
                if (response != null) {
                    coursesDetailsInterface.onSuccess(response)
                }

            } catch (e: ApiException) {
                coursesDetailsInterface.onFailure(e.message!!)
            } catch (e: Exception) {
                coursesDetailsInterface.onFailure(e.message!!)
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "Exception: $e")
            }
        }
    }
}