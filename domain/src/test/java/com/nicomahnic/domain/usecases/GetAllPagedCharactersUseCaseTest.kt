package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.repository.CharactersRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class GetAllPagedCharactersUseCaseTest {

    private lateinit var getAllPagedCharactersUseCase: GetAllPagedCharactersUseCase

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @BeforeEach
    fun setup() {
        getAllPagedCharactersUseCase = GetAllPagedCharactersUseCase(
            repository = charactersRepository
        )
    }

    @Test
    fun `check usecase is called`(){
        runBlocking {
            getAllPagedCharactersUseCase.invoke()

            verify(charactersRepository).getAllPagedCharacters()
        }
    }
}