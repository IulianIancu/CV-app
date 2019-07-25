package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("network")
    val network: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("username")
    val username: String = ""
)