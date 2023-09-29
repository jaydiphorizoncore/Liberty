package com.example.liberty.data.network.response.coursesdetailsresponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("can_access_app")
    val canAccessApp: Int,
    @SerializedName("is_upgrade")
    val isUpgrade: Int,
    @SerializedName("tagwise_data")
    val tagwiseData: List<TagwiseData>?
)