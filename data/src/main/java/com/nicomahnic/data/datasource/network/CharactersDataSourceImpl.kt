package com.nicomahnic.data.datasource.network

import android.util.Log
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.network.api.RickMortyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharactersDataSourceImpl(
    private val service: RickMortyService
) : CharactersDataSource {

    override suspend fun getAllCharacters(): Flow<String> {
        Log.e("NM", "LLEGUE AL DATASOURCE")
        val response = service.getCharactersByPage()
        Log.e("NM", "RESPUESTA -> ${response.body()?.info}")
        return flow {}
    }

}