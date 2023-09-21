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
class GetCharacterByIdUseCaseTest {

    private lateinit var getCharacterByIdUseCase: GetCharacterByIdUseCase

    @Mock
    private lateinit var charactersRepository: CharactersRepository

    @BeforeEach
    fun setup() {
        getCharacterByIdUseCase = GetCharacterByIdUseCase(
            repository = charactersRepository
        )
    }

    @Test
    fun `check usecase is called`(){
        runBlocking {
            whenever(getCharacterByIdUseCase(any()))
                .doReturn(Result.success(character))
            val result = getCharacterByIdUseCase.invoke(ANY_INT)

            assert(result.isSuccess)
            verify(charactersRepository).getCharacterById(ANY_INT)
        }
    }

    companion object {
        private const val ANY_INT = 0

        val character = CharactersObjectMother.mockModel()
    }
}