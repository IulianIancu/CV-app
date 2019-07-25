package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Award(
    @SerializedName("awarder")
    val awarder: String = "",
    @SerializedName("date")
    val date: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("title")
    val title: String = ""
)