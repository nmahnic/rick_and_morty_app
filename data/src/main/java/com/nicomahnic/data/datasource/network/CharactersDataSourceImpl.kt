package com.nicomahnic.data.datasource.network

import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.network.api.RickMortyService
import com.nicomahnic.data.datasource.network.mapper.CharactersMapper
import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.model.Character

class CharactersDataSourceImpl(
    private val service: RickMortyService,
    private val mapper: CharactersMapper
) : CharactersDataSource {

    override suspend fun getAllCharacters(): Result<CharactersNetwork> {
        val response = service.getCharactersByPage()
        val characters = response.body()?.let { mapper.toModel(it) }
        val error = Result.failure<CharactersNetwork>(Throwable("${response.errorBody()}"))
        return characters?.let { Result.success(it)} ?: error
    }

    override suspend fun getCharacterById(id: Int): Result<Character> {
        val response = service.getCharacterById(id)
        val character = response.body()?.let { mapper.toModel(it) }
        val error = Result.failure<Character>(Throwable("${response.errorBody()}"))
        return character?.let { Result.success(it)} ?: error
    }

}
