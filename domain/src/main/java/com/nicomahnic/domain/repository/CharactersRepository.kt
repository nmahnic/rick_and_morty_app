package com.nicomahnic.domain.repository

import com.nicomahnic.domain.model.Characters

interface CharactersRepository {

    suspend fun getAllCharacters(): Result<Characters>

}