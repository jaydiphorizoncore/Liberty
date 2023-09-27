package com.example.liberty.data.network.response.dashboardresponse


import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("advance_courses")
    val advanceCourses: String,
    @SerializedName("all_courses")
    val allCourses: String,
    @SerializedName("newest_courses")
    val newestCourses: String,
    @SerializedName("popular_courses")
    val popularCourses: String
)