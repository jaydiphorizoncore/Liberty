package com.example.liberty.data.network

import com.example.liberty.data.network.request.dashboardrequest.DashboardRequest
import com.example.liberty.data.network.request.loginrequest.LoginRequest
import com.example.liberty.data.network.response.dashboardresponse.DashboardResponse
import com.example.liberty.data.network.response.loginresponse.LoginResponse
import com.example.liberty.util.AppConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ApiInterface {

/*    @POST("check-username") // Adjust the endpoint as needed
    fun checkUserName(@Body request: LoginRequest): Call<LoginResponse>*/

    @POST("check-username")
    suspend fun checkUserName(
        @HeaderMap headerMap: Map<String, String>,
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @POST("member/get-dashboard-data")
    suspend fun getDashboard(
        @HeaderMap headerMap: Map<String, String>,
        @Body dashboardRequest: DashboardRequest
    ): Response<DashboardResponse>


    companion object {
        operator fun invoke(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder().addHeader(
                        "Authorization", "Bearer " + AppConstants.AUTHORIZATION_BEARER_TOKEN
                    ).build()
                    chain.proceed(newRequest)
                }).build()
            return Retrofit.Builder().baseUrl(AppConstants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)

        }

    }
}
