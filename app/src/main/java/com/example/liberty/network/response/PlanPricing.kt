package com.example.liberty.network.response


import com.google.gson.annotations.SerializedName

data class PlanPricing(
    @SerializedName("label")
    val label: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("price_btn_label")
    val priceBtnLabel: String,
    @SerializedName("price_label")
    val priceLabel: String
)