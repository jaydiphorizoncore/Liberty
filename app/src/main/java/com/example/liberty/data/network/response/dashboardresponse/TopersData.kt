package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class TopersData(
    @SerializedName("course_id")
    val courseId: Int,
    @SerializedName("course_name")
    val courseName: String,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)