package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Reference(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("reference")
    val reference: String = ""
)