package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("banner_data")
    val bannerData: List<BannerData>,
    @SerializedName("can_access_app")
    val canAccessApp: Int,
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("courses")
    val courses: Courses,
    @SerializedName("is_course")
    val isCourse: List<IsCourse>,
    @SerializedName("is_upgrade")
    val isUpgrade: Int,
    @SerializedName("notification")
    val notification: Int,
    @SerializedName("package_list")
    val packageList: List<Any>,
    @SerializedName("testimonials")
    val testimonials: Testimonials,
    @SerializedName("tests")
    val tests: List<Test>,
    @SerializedName("toppers")
    val toppers: Toppers,
    @SerializedName("type")
    val type: Type,
    @SerializedName("upcoming_payments")
    val upcomingPayments: List<Any>
)