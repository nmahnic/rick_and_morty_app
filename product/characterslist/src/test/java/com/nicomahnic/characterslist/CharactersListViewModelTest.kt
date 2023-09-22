package com.nicomahnic.characterslist

import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import com.nicomahnic.domain.usecases.SearchCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
@OptIn(ExperimentalCoroutinesApi::class)
class CharactersListViewModelTest {

    @Mock
    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase

    @Mock
    private lateinit var searchCharactersUseCase: SearchCharactersUseCase

    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    private lateinit var charactersListViewModel: CharactersListViewModel

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(dispatcher)
        charactersListViewModel = CharactersListViewModel(
            getAllCharactersUseCase,
            searchCharactersUseCase
        )
    }

    @Test
    fun `check searchCharactersUseCase is success` () {
        runBlocking {
            whenever(searchCharactersUseCase(any()))
                .doReturn(Result.success(listOf()))

            charactersListViewModel.searchCharacters(ANY_STRING)

            verify(searchCharactersUseCase).invoke(ANY_STRING)
        }
    }

    @Test
    fun `check searchCharactersUseCase is failure` () {
        runBlocking {
            whenever(searchCharactersUseCase(any()))
                .doReturn(Result.failure(Exception()))

            charactersListViewModel.searchCharacters(ANY_STRING)

            verify(searchCharactersUseCase).invoke(ANY_STRING)
        }
    }

    @Test
    fun `check getAllCharactersUseCase is success` () {
        runBlocking {
            whenever(getAllCharactersUseCase())
                .doReturn(Result.success(listOf()))

            charactersListViewModel.initialize()

            verify(getAllCharactersUseCase).invoke()
        }
    }

    @Test
    fun `check getAllCharactersUseCase is failure` () {
        runBlocking {
            whenever(getAllCharactersUseCase())
                .doReturn(Result.failure(Exception()))

            charactersListViewModel.initialize()

            verify(getAllCharactersUseCase).invoke()
        }
    }

    companion object {
        private const val ANY_STRING = "ANY_STRING"
    }
}