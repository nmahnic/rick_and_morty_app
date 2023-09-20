package com.nicomahnic.data.datasource

import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character

interface CharactersDataSource {
    suspend fun getAllCharacters(page: Int = 1): Result<CharactersNetwork>

    suspend fun searchCharacters(inputSearch: String): Result<CharactersNetwork>

    suspend fun getCharacterById(id: Int): Result<Character>

}