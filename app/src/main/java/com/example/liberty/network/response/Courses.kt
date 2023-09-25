package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class Courses(
    @SerializedName("advance_courses")
    val advanceCourses: AdvanceCourses,
    @SerializedName("all_courses")
    val allCourses: AllCourses,
    @SerializedName("newest_courses")
    val newestCourses: NewestCourses,
    @SerializedName("popular_courses")
    val popularCourses: PopularCourses
)