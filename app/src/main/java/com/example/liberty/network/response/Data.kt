package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("app_version")
    val appVersion: String,
    @SerializedName("can_access_app")
    val canAccessApp: Int,
    @SerializedName("device_name")
    val deviceName: String,
    @SerializedName("device_no")
    val deviceNo: String,
    @SerializedName("device_uuid")
    val deviceUuid: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("is_upgrade")
    val isUpgrade: Int,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("member_id")
    val memberId: Int,
    @SerializedName("mobile_number")
    val mobileNumber: String,
    @SerializedName("status")
    val status: Int
)