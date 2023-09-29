package com.example.liberty.data.network.request.categorydetailsrequest


import com.google.gson.annotations.SerializedName

data class CategoryDetailsRequest(
    @SerializedName("app_version")
    val appVersion: String,
    @SerializedName("device_type")
    val deviceType: Int,
    @SerializedName("device_version")
    val deviceVersion: String,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("member_id")
    val memberId: String
)