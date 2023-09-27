package com.example.liberty.ui.dashboard.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.liberty.util.ApiException
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.util.AppConstants
import com.example.liberty.ui.dashboard.home.DashboardInterface
import com.example.liberty.data.network.request.dashboardrequest.DashboardRequest
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