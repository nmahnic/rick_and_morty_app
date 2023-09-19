package com.nicomahnic.data.datasource.network.api

import com.nicomahnic.data.datasource.network.model.CharactersNetworkResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickMortyService {

    @GET("character")
    suspend fun getAllCharacters() : Response<CharactersNetworkResponse>
}