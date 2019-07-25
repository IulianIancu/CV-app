package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("keywords")
    val keywords: List<String> = listOf(),
    @SerializedName("level")
    val level: String = "",
    @SerializedName("name")
    val name: String = ""
)