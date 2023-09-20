package com.nicomahnic.data.datasource

import com.nicomahnic.domain.model.CharactersNetwork

interface CharactersDataSource {
    suspend fun getAllCharacters(): Result<CharactersNetwork>

}