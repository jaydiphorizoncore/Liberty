package com.example.liberty.data.network.response.coursesdetailsresponse


import com.google.gson.annotations.SerializedName

data class CoursesDetailsResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_message")
    val statusMessage: String
)