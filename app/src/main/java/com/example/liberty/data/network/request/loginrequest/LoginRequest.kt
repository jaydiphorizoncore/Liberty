package com.example.liberty.data.network.request.loginrequest


import com.google.gson.annotations.SerializedName

data class LoginRequest  (
    @SerializedName("app_version")
    val appVersion: String,
    @SerializedName("device_model")
    val deviceModel: String,
    @SerializedName("device_name")
    val deviceName: String,
    @SerializedName("device_no")
    val deviceNo: String,
    @SerializedName("device_platform")
    val devicePlatform: String,
    @SerializedName("device_type")
    val deviceType: Int,
    @SerializedName("device_uuid")
    val deviceUuid: String,
    @SerializedName("device_version")
    val deviceVersion: String,
    @SerializedName("mode")
    val mode: String,
    @SerializedName("username")
    val username: String
)