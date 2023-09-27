package com.example.liberty.ui.dashboard.home

import com.example.liberty.data.network.response.dashboardresponse.DashboardResponse

interface DashboardInterface {

    fun onStarted()
    fun onSuccess(dashboardResponse: DashboardResponse?)
    fun onFailure(message: String)
}