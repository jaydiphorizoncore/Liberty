package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class IsCourse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: String
)