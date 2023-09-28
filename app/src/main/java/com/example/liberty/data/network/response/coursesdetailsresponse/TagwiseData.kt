package com.example.liberty.data.network.response.coursesdetailsresponse


import com.google.gson.annotations.SerializedName

data class TagwiseData(
    @SerializedName("admission_id")
    val admissionId: Int,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("amount_in_rupees")
    val amountInRupees: String,
    @SerializedName("bg_colour")
    val bgColour: String,
    @SerializedName("can_renew")
    val canRenew: Int,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_by")
    val createdBy: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("final_amount")
    val finalAmount: Int,
    @SerializedName("final_amount_label")
    val finalAmountLabel: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("is_course")
    val isCourse: Int,
    @SerializedName("is_course_bg_colour")
    val isCourseBgColour: String,
    @SerializedName("is_course_label")
    val isCourseLabel: String,
    @SerializedName("is_expired")
    val isExpired: Int,
    @SerializedName("is_public")
    val isPublic: Int,
    @SerializedName("is_purchased")
    val isPurchased: Int,
    @SerializedName("is_show_image")
    val isShowImage: Int,
    @SerializedName("label_total_materials")
    val labelTotalMaterials: String,
    @SerializedName("label_total_videos")
    val labelTotalVideos: String,
    @SerializedName("media_image_url")
    val mediaImageUrl: String,
    @SerializedName("media_url")
    val mediaUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("no_of_enrolled_student")
    val noOfEnrolledStudent: Int,
    @SerializedName("plan_pricing")
    val planPricing: PlanPricing,
    @SerializedName("popup_amount")
    val popupAmount: Int,
    @SerializedName("popup_btn_back_label")
    val popupBtnBackLabel: String,
    @SerializedName("popup_btn_label")
    val popupBtnLabel: String,
    @SerializedName("popup_description")
    val popupDescription: String,
    @SerializedName("popup_title")
    val popupTitle: String,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("total_materials")
    val totalMaterials: Int,
    @SerializedName("total_videos")
    val totalVideos: Int,
    @SerializedName("type")
    val type: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)