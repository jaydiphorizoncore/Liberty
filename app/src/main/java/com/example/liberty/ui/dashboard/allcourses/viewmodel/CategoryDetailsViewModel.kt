package com.example.liberty.ui.dashboard.allcourses.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.liberty.data.network.request.categorydetailsrequest.CategoryDetailsRequest
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.ui.dashboard.allcourses.CategoryInterface
import com.example.liberty.util.ApiException
import com.example.liberty.util.AppConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryDetailsViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    lateinit var categoryInterface: CategoryInterface

    fun getCoursesDetails() {
        categoryInterface.onStarted()

        CoroutineScope(Dispatchers.Main).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token


            val categoryDetailsRequest = CategoryDetailsRequest(
                memberId = "1563",
                langCode = "en",
                deviceType = 1,
                deviceVersion = "1.0",
                appVersion = "1.3.8"
            )
            try {

                val response = apiRepository.getCategoryDetails(headers, categoryDetailsRequest)
                Log.d("TAG", "response: $response")
                if (response != null) {
                    categoryInterface.onSuccess(response)
                }

            } catch (e: ApiException) {
                categoryInterface.onFailure(e.message!!)
            } catch (e: Exception) {
                categoryInterface.onFailure(e.message!!)
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "Exception: $e")
            }
        }
    }
}