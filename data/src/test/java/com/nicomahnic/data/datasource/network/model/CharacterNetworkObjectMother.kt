package com.nicomahnic.data.datasource.network.model

import com.nicomahnic.domain.model.CharacterModel
import com.nicomahnic.domain.model.LocationModel
import com.nicomahnic.domain.model.OriginModel

object CharacterNetworkObjectMother {

    fun mockSomeCharactersModels(items: Int = 6) = getSome(items) {
        mockCharacterModel()
    }

    fun mockCharactersEntityResponse() = CharactersNetworkEntityResponse(
        info = mockInfoNetworkEntity(),
        results = mockSomeCharacterEntityResponse()
    )

    private fun mockSomeCharacterEntityResponse(items: Int = 6) = getSome(items) {
        mockCharacterEntityResponse()
    }

    fun mockCharacterModel() = CharacterModel(
        created = ANY_STRING,
        episode = listOf(),
        gender = ANY_STRING,
        id = 0,
        image = ANY_STRING,
        location = mockLocationModel(),
        name = ANY_STRING,
        origin = mockOriginModel(),
        species = ANY_STRING,
        status = ANY_STRING,
        type = ANY_STRING,
        url = ANY_STRING
    )

    fun mockCharacterEntityResponse() = CharacterNetworkEntityResponse(
        created = ANY_STRING,
        episode = listOf(),
        gender = ANY_STRING,
        id = 0,
        image = ANY_STRING,
        location = mockLocationNetworkEntity(),
        name = ANY_STRING,
        origin = mockOriginNetworkEntity(),
        species = ANY_STRING,
        status = ANY_STRING,
        type = ANY_STRING,
        url = ANY_STRING
    )

    private fun mockInfoNetworkEntity() = InfoNetworkEntity(
        count = 0,
        pages = 1
    )

    private fun mockLocationNetworkEntity() = LocationNetworkEntity(
        name = ANY_STRING,
        url = ANY_STRING
    )

    private fun mockOriginNetworkEntity() = OriginNetworkEntity(
        name = ANY_STRING,
        url = ANY_STRING
    )

    private fun mockLocationModel() = LocationModel(
        name = ANY_STRING,
        url = ANY_STRING
    )

    private fun mockOriginModel() = OriginModel(
        name = ANY_STRING,
        url = ANY_STRING
    )

    private const val ANY_STRING = "ANY_STRING"
}