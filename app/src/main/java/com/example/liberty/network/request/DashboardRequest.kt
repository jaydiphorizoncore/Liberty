package com.example.liberty.network.request


import com.google.gson.annotations.SerializedName

data class DashboardRequest(
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