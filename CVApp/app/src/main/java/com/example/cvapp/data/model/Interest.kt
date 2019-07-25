package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Interest(
    @SerializedName("keywords")
    val keywords: List<String> = listOf(),
    @SerializedName("name")
    val name: String = ""
)