package com.nicomahnic.domain.repository

import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getAllCharacters(): Flow<String>

}