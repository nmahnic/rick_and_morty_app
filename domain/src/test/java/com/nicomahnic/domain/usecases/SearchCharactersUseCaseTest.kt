package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharactersObjectMother
import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.runBlocking
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
class SearchCharactersUseCaseTest {

    private lateinit var searchCharactersUseCase: SearchCharactersUseCase

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @BeforeEach
    fun setup() {
        searchCharactersUseCase = SearchCharactersUseCase(
            repository = charactersRepository
        )
    }

    @Test
    fun `check usecase is called`(){
        runBlocking {
            whenever(searchCharactersUseCase(any()))
                .doReturn(Result.success(characterList))
            val result = searchCharactersUseCase.invoke(ANY_STRING)

            assert(result.isSuccess)
            verify(charactersRepository).searchCharacters(ANY_STRING)
        }
    }

    companion object {
        private const val ANY_STRING = "ANY_STRING"

        val characterList = CharactersObjectMother.mockSomeModels()
    }
}