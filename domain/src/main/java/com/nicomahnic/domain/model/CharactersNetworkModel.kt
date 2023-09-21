package com.nicomahnic.domain.model

data class CharacterModel(
    val created: String = "",
    val episode: List<String> = emptyList(),
    val gender: String = "",
    val id: Int = 0,
    val image: String = "",
    val location: LocationModel = LocationModel(),
    val name: String = "",
    val origin: OriginModel = OriginModel(),
    val species: String = "",
    val status: String = "",
    val type: String = "",
    val url: String = ""
)

data class LocationModel(
    val name: String = "",
    val url: String = ""
)

data class OriginModel(
    val name: String = "",
    val url: String =""
)