package com.example.liberty.data.network.request.coursesdetailsrequest


import com.google.gson.annotations.SerializedName

data class CoursesDetailsRequest(
    @SerializedName("app_version")
    val appVersion: String,
    @SerializedName("device_type")
    val deviceType: Int,
    @SerializedName("device_version")
    val deviceVersion: String,
    @SerializedName("is_course")
    val isCourse: String,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("member_id")
    val memberId: String,
    @SerializedName("type")
    val type: String
)