package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharactersObjectMother
import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
class GetAllCharactersUseCaseTest {

    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @BeforeEach
    fun setup() {
        getAllCharactersUseCase = GetAllCharactersUseCase(
            repository = charactersRepository
        )
    }

    @Test
    fun `check usecase is called`(){
        runBlocking {
            whenever(getAllCharactersUseCase())
                .doReturn(Result.success(characterList))
            val result = getAllCharactersUseCase.invoke()

            assert(result.isSuccess)
            verify(charactersRepository).getAllCharacters()
        }
    }

    companion object {
        val characterList = CharactersObjectMother.mockSomeModels()
    }
}