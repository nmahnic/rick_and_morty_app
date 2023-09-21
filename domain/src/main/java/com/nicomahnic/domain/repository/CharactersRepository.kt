package com.nicomahnic.domain.repository

import androidx.paging.PagingData
import com.nicomahnic.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getAllCharacters(): Result<List<CharacterModel>>

    suspend fun searchCharacters(inputSearch: String): Result<List<CharacterModel>>

    suspend fun getCharacterById(id: Int): Result<CharacterModel>

    suspend fun getAllPagedCharacters(): Flow<PagingData<CharacterModel>>

}