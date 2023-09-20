package com.nicomahnic.data.datasource.network.model

data class CharactersNetworkEntityResponse(
    val info: InfoNetworkEntity,
    val results: List<CharacterNetworkEntityResponse>
)

data class InfoNetworkEntity(
    val count: Int,
    val next: String? = null,
    val pages: Int,
    val prev: String? = null
)

data class CharacterNetworkEntityResponse(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationNetworkEntity,
    val name: String,
    val origin: OriginNetworkEntity,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationNetworkEntity(
    val name: String,
    val url: String
)

data class OriginNetworkEntity(
    val name: String,
    val url: String
)