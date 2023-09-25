package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class IsCourse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: String
)