package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_display_date")
    val createdDisplayDate: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: Any
)