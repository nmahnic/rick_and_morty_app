package com.nicomahnic.data.repository

import com.nicomahnic.domain.repository.CharactersRepository
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.domain.model.Character
import com.nicomahnic.domain.model.CharactersNetwork

class CharactersRepositoryImpl(
    private val dataSource: CharactersDataSource
): CharactersRepository {

    override suspend fun getAllCharacters(): Result<CharactersNetwork> {
        return dataSource.getAllCharacters()
    }

    override suspend fun getCharacterById(id: Int): Result<Character> {
        return dataSource.getCharacterById(id)
    }

}