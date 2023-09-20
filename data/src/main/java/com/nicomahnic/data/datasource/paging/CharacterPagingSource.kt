package com.nicomahnic.data.datasource.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nicomahnic.data.datasource.CharactersDataSource
import com.nicomahnic.domain.model.Character
import okio.IOException
import retrofit2.HttpException

class CharacterPagingSource(
    private val remoteDataSource: CharactersDataSource,
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val currentPage = params.key ?: 1
            val characters = remoteDataSource.getAllCharacters(
                page = currentPage
            ).getOrNull()!!
            LoadResult.Page(
                data = characters.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (characters.results.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

}
