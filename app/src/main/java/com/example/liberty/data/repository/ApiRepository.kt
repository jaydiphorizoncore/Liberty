package com.example.liberty.data.repository

import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.network.SafeApiRequest
import com.example.liberty.data.network.request.loginrequest.LoginRequest
import com.example.liberty.data.network.response.loginresponse.LoginResponse
import com.example.liberty.data.network.request.dashboardrequest.DashboardRequest
import com.example.liberty.data.network.response.dashboardresponse.DashboardResponse

class ApiRepository(private val apiInterface: ApiInterface) : SafeApiRequest() {

    suspend fun getDashboard(
        headerMap: Map<String, String>,
        dashboardRequest: DashboardRequest
    ): DashboardResponse? {
        return apiRequest { apiInterface.getDashboard(headerMap, dashboardRequest) }
    }

    suspend fun getLogin(
        headerMap: Map<String, String>,
        loginRequest: LoginRequest
    ): LoginResponse? {
        return apiRequest { apiInterface.checkUserName(headerMap, loginRequest) }
    }
}