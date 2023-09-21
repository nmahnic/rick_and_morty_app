package com.nicomahnic.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nicomahnic.domain.repository.CharactersRepository
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.data.datasource.paging.CharacterPagingSource
import com.nicomahnic.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val dataSource: CharactersDataSource
): CharactersRepository {

    override suspend fun getAllCharacters(): Result<List<CharacterModel>> {
        return dataSource.getAllCharacters()
    }

    override suspend fun searchCharacters(inputSearch: String): Result<List<CharacterModel>> {
        return dataSource.searchCharacters(inputSearch)
    }

    override suspend fun getCharacterById(id: Int): Result<CharacterModel> {
        return dataSource.getCharacterById(id)
    }

    override suspend fun getAllPagedCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = MAX_PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE
            ),
            pagingSourceFactory = {
                CharacterPagingSource(dataSource)
            }
        ).flow
    }

    companion object {
        private const val MAX_PAGE_SIZE = 10
        private const val PREFETCH_DISTANCE = 2
    }
}