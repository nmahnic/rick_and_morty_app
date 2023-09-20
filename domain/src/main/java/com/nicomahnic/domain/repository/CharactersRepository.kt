package com.nicomahnic.domain.repository

import com.nicomahnic.domain.model.CharactersNetwork

interface CharactersRepository {

    suspend fun getAllCharacters(): Result<CharactersNetwork>

}