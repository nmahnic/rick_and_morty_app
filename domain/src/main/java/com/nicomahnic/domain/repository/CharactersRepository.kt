package com.nicomahnic.domain.repository

import androidx.paging.PagingData
import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getAllCharacters(): Result<CharactersNetwork>

    suspend fun searchCharacters(inputSearch: String): Result<CharactersNetwork>

    suspend fun getCharacterById(id: Int): Result<Character>

    suspend fun getAllPagedCharacters(): Flow<PagingData<Character>>

}