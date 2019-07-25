package com.example.cvapp.data.model

import com.google.gson.annotations.SerializedName

data class CV(
    @SerializedName("awards")
    val awards: List<Award> = listOf(),
    @SerializedName("basics")
    val basics: Basics = Basics(),
    @SerializedName("education")
    val education: List<Education> = listOf(),
    @SerializedName("interests")
    val interests: List<Interest> = listOf(),
    @SerializedName("languages")
    val languages: List<Language> = listOf(),
    @SerializedName("publications")
    val publications: List<Publication> = listOf(),
    @SerializedName("references")
    val references: List<Reference> = listOf(),
    @SerializedName("skills")
    val skills: List<Skill> = listOf(),
    @SerializedName("volunteer")
    val volunteer: List<Volunteer> = listOf(),
    @SerializedName("work")
    val work: List<Work> = listOf()
)