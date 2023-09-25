package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class TestimonialsData(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
    @SerializedName("media_url")
    val mediaUrl: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("status")
    val status: Int
)