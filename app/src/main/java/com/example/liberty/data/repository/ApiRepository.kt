package com.example.liberty.data.repository

import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.network.SafeApiRequest
import com.example.liberty.data.network.request.categorydetailsrequest.CategoryDetailsRequest
import com.example.liberty.data.network.request.coursesdetailsrequest.CoursesDetailsRequest
import com.example.liberty.data.network.request.loginrequest.LoginRequest
import com.example.liberty.data.network.response.loginresponse.LoginResponse
import com.example.liberty.data.network.request.dashboardrequest.DashboardRequest
import com.example.liberty.data.network.response.categorydetailsresponse.CategoryDetailsResponse
import com.example.liberty.data.network.response.coursesdetailsresponse.CoursesDetailsResponse
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

    suspend fun getCoursesDetails(
        headerMap: Map<String, String>,
        coursesDetailsRequest: CoursesDetailsRequest
    ): CoursesDetailsResponse? {
        return apiRequest { apiInterface.getCoursesDetails(headerMap, coursesDetailsRequest) }
    }

    suspend fun getCategoryDetails(
        headerMap: Map<String, String>,
        categoryDetailsRequest: CategoryDetailsRequest
    ): CategoryDetailsResponse? {
        return apiRequest { apiInterface.getCategoryDetails(headerMap, categoryDetailsRequest) }
    }

}