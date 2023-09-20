package com.nicomahnic.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nicomahnic.domain.repository.CharactersRepository
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.paging.CharacterPagingSource
import com.nicomahnic.domain.model.Character
import com.nicomahnic.domain.model.CharactersNetwork
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val dataSource: CharactersDataSource
): CharactersRepository {

    override suspend fun getAllCharacters(): Result<CharactersNetwork> {
        return dataSource.getAllCharacters()
    }

    override suspend fun getCharacterById(id: Int): Result<Character> {
        return dataSource.getCharacterById(id)
    }

    override suspend fun getAllPagedCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
                CharacterPagingSource(dataSource)
            }
        ).flow
    }

    companion object {
        private const val MAX_PAGE_SIZE = 10
    }
}