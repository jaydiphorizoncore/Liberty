package com.example.liberty.network

import com.example.liberty.network.request.DashboardRequest
import com.example.liberty.network.request.LoginRequest
import com.example.liberty.network.response.DashboardResponse
import com.example.liberty.network.response.LoginResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface ApiInterface {

    @POST("check-username") // Adjust the endpoint as needed
    fun checkUserNAme(@Body request: LoginRequest): Call<LoginResponse>

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
