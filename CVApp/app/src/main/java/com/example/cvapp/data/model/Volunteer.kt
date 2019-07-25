package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Volunteer(
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("highlights")
    val highlights: List<String> = listOf(),
    @SerializedName("organization")
    val organization: String = "",
    @SerializedName("position")
    val position: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("website")
    val website: String = ""
)