package com.nicomahnic.data.datasource

import com.nicomahnic.domain.model.Characters

interface CharactersDataSource {
    suspend fun getAllCharacters(): Result<Characters>

}