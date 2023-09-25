package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class BannerData(
    @SerializedName("banner_url")
    val bannerUrl: String,
    @SerializedName("button_title")
    val buttonTitle: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)