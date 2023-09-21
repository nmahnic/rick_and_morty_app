package com.nicomahnic.data.datasource.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.domain.model.CharacterModel
import retrofit2.HttpException

class CharacterPagingSource(
    private val remoteDataSource: CharactersDataSource,
) : PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val currentPage = params.key ?: STARTING_INDEX
            val characters = remoteDataSource.getAllCharacters(
                page = currentPage
            ).getOrThrow()
            LoadResult.Page(
                data = characters,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (characters.isEmpty()) null else currentPage + 1
            )
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    companion object {
        private const val STARTING_INDEX = 1
    }

}
