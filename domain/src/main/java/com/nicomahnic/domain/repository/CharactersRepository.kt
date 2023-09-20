package com.nicomahnic.domain.repository

import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character

interface CharactersRepository {

    suspend fun getAllCharacters(): Result<CharactersNetwork>

    suspend fun getCharacterById(id: Int): Result<Character>

}