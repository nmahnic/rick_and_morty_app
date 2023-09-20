package com.nicomahnic.domain.model

data class CharactersNetwork(
    val info: InfoNetwork,
    val results: List<Character>
)

data class InfoNetwork(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String? = null
)

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)