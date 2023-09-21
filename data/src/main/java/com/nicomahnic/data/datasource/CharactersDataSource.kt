package com.nicomahnic.data.datasource

import com.nicomahnic.domain.model.CharacterModel

interface CharactersDataSource {
    suspend fun getAllCharacters(page: Int = 1): Result<List<CharacterModel>>

    suspend fun searchCharacters(inputSearch: String): Result<List<CharacterModel>>

    suspend fun getCharacterById(id: Int): Result<CharacterModel>

}