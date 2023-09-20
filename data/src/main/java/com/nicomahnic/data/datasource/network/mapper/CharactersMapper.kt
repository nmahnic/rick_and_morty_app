package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import com.nicomahnic.domain.model.Characters

interface CharactersMapper {
    fun toModel(entity: CharactersNetworkEntityResponse): Characters

}