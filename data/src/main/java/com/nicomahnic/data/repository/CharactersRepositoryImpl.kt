package com.nicomahnic.data.repository

import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import android.util.Log
import com.nicomahnic.data.datasource.CharactersDataSource

class CharactersRepositoryImpl(
    private val dataSource: CharactersDataSource
): CharactersRepository {

    override suspend fun getAllCharacters(): Flow<String>{
        Log.e("NM", "LLEGUE AL REPO")
        return dataSource.getAllCharacters()
    }

}