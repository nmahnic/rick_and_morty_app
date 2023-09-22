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
        return try {
            val response = service.getCharactersByPage(page)
            val characters = response.body()?.let { mapper.toListModel(it) }
            characters?.let { Result.success(it) } ?: run {
                Result.failure(Exception("${response.errorBody()}"))
            }
        } catch (e: Exception){
            Result.failure(Exception(e.localizedMessage))
        }
    }

    override suspend fun searchCharacters(inputSearch: String): Result<List<CharacterModel>> {
        return try{
            val response = service.searchCharacters(inputSearch)
            val characters = response.body()?.let { mapper.toListModel(it) }
            characters?.let { Result.success(it) } ?: run {
                Result.failure(Exception("${response.errorBody()}"))
            }
        } catch (e: Exception){
            Result.failure(Exception(e.localizedMessage))
        }
    }

    override suspend fun getCharacterById(id: Int): Result<CharacterModel> {
        return try {
            val response = service.getCharacterById(id)
            val character = response.body()?.let { mapper.toModel(it) }
            character?.let { Result.success(it) } ?: run {
                Result.failure(Exception("${response.errorBody()}"))
            }
        } catch (e: Exception){
            Result.failure(Exception(e.localizedMessage))
        }
    }

}
