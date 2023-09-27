package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class PopularCourses(
    @SerializedName("courses")
    val courses: List<Course>,
    @SerializedName("image_icon_url")
    val imageIconUrl: String,
    @SerializedName("name")
    val name: String
)