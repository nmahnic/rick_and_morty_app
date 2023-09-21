package com.nicomahnic.data.datasource.network

import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.network.api.RickMortyService
import com.nicomahnic.data.datasource.network.mapper.CharactersMapper
import com.nicomahnic.domain.model.CharacterModel

class CharactersDataSourceImpl(
    private val service: RickMortyService,
    private val mapper: CharactersMapper
) : CharactersDataSource {

    override suspend fun getAllCharacters(page: Int): Result<List<CharacterModel>> {
        val response = service.getCharactersByPage(page)
        val characters = response.body()?.let { mapper.toListModel(it) }
        return characters?.let { Result.success(it)} ?: run {
            Result.failure(Exception("${response.errorBody()}"))
        }
    }

    override suspend fun searchCharacters(inputSearch: String): Result<List<CharacterModel>> {
        val response = service.searchCharacters(inputSearch)
        val characters = response.body()?.let { mapper.toListModel(it) }
        return characters?.let { Result.success(it)} ?: run {
            Result.failure(Exception("${response.errorBody()}"))
        }
    }

    override suspend fun getCharacterById(id: Int): Result<CharacterModel> {
        val response = service.getCharacterById(id)
        val character = response.body()?.let { mapper.toModel(it) }
        return character?.let { Result.success(it)} ?: run {
            Result.failure(Exception("${response.errorBody()}"))
        }
    }

}
