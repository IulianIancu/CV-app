package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class Basics(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("label")
    val label: String = "",
    @SerializedName("location")
    val location: Location = Location(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("picture")
    val picture: String = "",
    @SerializedName("profiles")
    val profiles: List<Profile> = listOf(),
    @SerializedName("summary")
    val summary: String = "",
    @SerializedName("website")
    val website: String = ""
)