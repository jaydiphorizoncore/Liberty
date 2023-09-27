package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class NewestCourses(
    @SerializedName("image_icon_url")
    val imageIconUrl: String,
    @SerializedName("name")
    val name: String
)