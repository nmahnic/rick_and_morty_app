package com.nicomahnic.data.repository

import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import android.util.Log
import com.nicomahnic.data.datasource.network.api.RickMortyService

class CharactersRepositoryImpl(
    private val service: RickMortyService
): CharactersRepository {

    override suspend fun getAllCharacters(): Flow<String>{
        Log.e("NM", "LLEGUE AL REPO IMPL")
        val response = service.getAllCharacters()
        Log.e("NM", "RESPUESTA -> $response")
        return flow {}
    }

}