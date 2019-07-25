package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("fluency")
    val fluency: String = "",
    @SerializedName("language")
    val language: String = ""
)