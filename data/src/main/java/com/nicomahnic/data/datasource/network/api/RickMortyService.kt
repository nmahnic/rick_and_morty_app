package com.nicomahnic.data.datasource.network.api

import com.nicomahnic.data.datasource.network.model.CharacterNetworkEntityResponse
import com.nicomahnic.data.datasource.network.model.CharactersNetworkEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {

    @GET("character")
    suspend fun getCharactersByPage(@Query("page") page: Int = 1) : Response<CharactersNetworkEntityResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int) : Response<CharacterNetworkEntityResponse>
}