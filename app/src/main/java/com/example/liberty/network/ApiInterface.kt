package com.example.liberty.network

import com.example.liberty.network.request.LoginRequest
import com.example.liberty.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
 /*   @GET("check-username")
      fun checkUserNAme(): Call<LoginResponse>

      @POST("check-username")
      fun sendRequest(@Body dataRequest:LoginRequest):retrofit2.Callback<LoginRequest>*/

    @POST("check-username") // Adjust the endpoint as needed
    fun checkUserNAme(@Body request: LoginRequest): Call<LoginResponse>
}
