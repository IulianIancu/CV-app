package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Education(
    @SerializedName("area")
    val area: String = "",
    @SerializedName("courses")
    val courses: List<String> = listOf(),
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("gpa")
    val gpa: String = "",
    @SerializedName("institution")
    val institution: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("studyType")
    val studyType: String = ""
)