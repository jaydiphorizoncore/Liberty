package com.example.liberty.data.network.response.categorydetailsresponse


import com.google.gson.annotations.SerializedName

data class CategoriesData(
    @SerializedName("courses")
    val courses: List<Course>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: Any
)