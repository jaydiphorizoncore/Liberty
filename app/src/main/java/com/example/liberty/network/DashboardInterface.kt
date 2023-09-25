package com.example.liberty.network

import com.example.liberty.network.response.DashboardResponse

interface DashboardInterface {

    fun onStarted()
    fun onSuccess(dashboardResponse: DashboardResponse?)
    fun onFailure(message: String)
}