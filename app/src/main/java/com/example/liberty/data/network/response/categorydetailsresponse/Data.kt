package com.example.liberty.data.network.response.categorydetailsresponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("can_access_app")
    val canAccessApp: Int,
    @SerializedName("categories_data")
    val categoriesData: List<CategoriesData>,
    @SerializedName("is_upgrade")
    val isUpgrade: Int
)