package com.nicomahnic.data.datasource.network

import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.network.api.RickMortyService
import com.nicomahnic.data.datasource.network.mapper.CharactersMapper
import com.nicomahnic.domain.model.CharactersNetwork

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

}
