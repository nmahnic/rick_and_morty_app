package com.nicomahnic.data.datasource

import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character

interface CharactersDataSource {
    suspend fun getAllCharacters(): Result<CharactersNetwork>

    suspend fun getCharacterById(id: Int): Result<Character>

}