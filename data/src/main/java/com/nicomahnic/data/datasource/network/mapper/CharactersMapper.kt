package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharacterNetworkEntityResponse
import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character

interface CharactersMapper {
    fun toModel(entity: CharactersNetworkEntityResponse): CharactersNetwork
    fun toModel(entity: CharacterNetworkEntityResponse): Character

}