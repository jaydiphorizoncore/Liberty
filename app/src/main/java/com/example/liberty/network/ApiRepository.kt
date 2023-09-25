package com.example.liberty.network

import com.example.liberty.network.request.DashboardRequest
import com.example.liberty.network.response.DashboardResponse
import retrofit2.Response
import retrofit2.http.HeaderMap

class ApiRepository(private val apiInterface: ApiInterface) : SafeApiRequest() {

    suspend fun dashboard(
        headerMap: Map<String, String>,
        dashboardRequest: DashboardRequest
    ): DashboardResponse? {
        return apiRequest { apiInterface.dashboard(headerMap, dashboardRequest) }
    }
}