package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Publication(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("publisher")
    val publisher: String = "",
    @SerializedName("releaseDate")
    val releaseDate: String = "",
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("website")
    val website: String = ""
)