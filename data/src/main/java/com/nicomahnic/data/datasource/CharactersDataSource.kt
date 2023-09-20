package com.nicomahnic.data.datasource

import kotlinx.coroutines.flow.Flow

interface CharactersDataSource {
    suspend fun getAllCharacters(): Flow<String>

}