package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharacterNetworkEntityResponse
import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import com.nicomahnic.domain.model.CharacterModel

interface CharactersMapper {
    fun toModel(entity: CharacterNetworkEntityResponse): CharacterModel
    fun toListModel(entity: CharactersNetworkEntityResponse): List<CharacterModel>

}