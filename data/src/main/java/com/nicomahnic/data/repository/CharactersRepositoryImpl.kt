package com.nicomahnic.data.repository

import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import android.util.Log

class CharactersRepositoryImpl: CharactersRepository {

    override suspend fun getAllCharacters(): Flow<String>{
        Log.e("NM", "LLEGUE AL REPO IMPL")
        return flow {}
    }

}