package com.example.liberty.network.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.liberty.network.ApiException
import com.example.liberty.network.ApiRepository
import com.example.liberty.network.AppConstants
import com.example.liberty.network.DashboardInterface
import com.example.liberty.network.request.DashboardRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    lateinit var dashboardInterface: DashboardInterface
    fun getDashboard() {
        dashboardInterface.onStarted()

        CoroutineScope(Dispatchers.Main).launch {
            val token = AppConstants.TOKEN
            val headers = HashMap<String, String>()
            headers[AppConstants.KEY] = token

            val dashboardRequest = DashboardRequest("1.3.8", 1, "1.0", "en", "1563")
            try {

                val response = apiRepository.getDashboard(headers, dashboardRequest)
                Log.d("TAG", "getDashboard: $response")
                if (response != null) {
                    dashboardInterface.onSuccess(response)
                }

            } catch (e: ApiException) {
                dashboardInterface.onFailure(e.message!!)
            } catch (e: Exception) {
                Log.e(this::class.simpleName, e.message.toString())
                Log.e("Exception", "Exception: $e")
            }

        }
    }
}