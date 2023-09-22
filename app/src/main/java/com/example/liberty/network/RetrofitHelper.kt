package com.example.liberty.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private const val BASEURL = "http://live.libertygroup.in/api/v2/"

    private const val authToken =
        "0ea4e3e69cb3bae2e3a7838db6ac66849a3908b8833c2d0e8d0504cd8bc8d31322812505356b4f8g"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(authToken))
                .build()
        )
        .build()

    val apiService: ApiInterface = retrofit.create(ApiInterface::class.java)

}

