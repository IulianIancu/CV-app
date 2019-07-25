package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address")
    val address: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("countryCode")
    val countryCode: String = "",
    @SerializedName("postalCode")
    val postalCode: String = "",
    @SerializedName("region")
    val region: String = ""
)