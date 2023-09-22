package com.nicomahnic.data.datasource

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nicomahnic.data.datasource.network.model.CharacterNetworkObjectMother
import com.nicomahnic.data.datasource.paging.CharacterPagingSource
import com.nicomahnic.domain.model.CharacterModel
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import retrofit2.HttpException
import retrofit2.Response

@ExtendWith(MockitoExtension::class)
class CharacterPagingSourceTest {

    @Mock
    private lateinit var remoteDataSource: CharactersDataSource

    private lateinit var characterPagingSource: CharacterPagingSource

    @BeforeEach
    fun setup() {
        characterPagingSource = CharacterPagingSource(
            remoteDataSource = remoteDataSource
        )
    }

    @Test
    fun `characters paging source load - failure - unknown error`() {
        runBlocking {
            val error = Exception()
            whenever(remoteDataSource.getAllCharacters((any()))).doReturn(Result.failure(error))

            val expectedResult = PagingSource.LoadResult.Error<Int, CharacterModel>(error)

            val result = characterPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = 0, loadSize = 1, placeholdersEnabled = false
                )
            )

            assert(expectedResult == result)
        }
    }

    @Test
    fun `characters paging source load - failure - http error`() {
        runBlocking {
            val error = HttpException(
                Response.error<Any>(
                    409,
                    "".toResponseBody("plain/text".toMediaTypeOrNull())
                )
            )
            whenever(remoteDataSource.getAllCharacters((any()))).doReturn(Result.failure(error))

            val expectedResult = PagingSource.LoadResult.Error<Int, CharacterModel>(error)

            val result = characterPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = 0, loadSize = 1, placeholdersEnabled = false
                )
            )

            assert(expectedResult == result)
        }
    }

    @Test
    fun `characters paging source refresh - success`() {
        runBlocking {
            whenever(remoteDataSource.getAllCharacters((any()))).doReturn(
                    Result.success(
                        characterListResponse
                    )
                )

            val expectedResult = PagingSource.LoadResult.Page(
                data = characterListResponse, prevKey = null, nextKey = 2
            )

            val result = characterPagingSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null, loadSize = 1, placeholdersEnabled = false
                )
            )

            assert(expectedResult == result)
        }
    }

    @Test
    fun `check getRefreshKey is called`() {
        val key = characterPagingSource.getRefreshKey(PagingState(
            listOf(),
            null,
            PagingConfig(
                pageSize = ANY_INT,
                prefetchDistance = ANY_INT
            ),
            leadingPlaceholderCount = ANY_INT
        ))

        assert(key == null)
    }

    companion object {
        private const val ANY_INT = 0
        private val characterListResponse = CharacterNetworkObjectMother.mockSomeCharactersModels()

    }
}