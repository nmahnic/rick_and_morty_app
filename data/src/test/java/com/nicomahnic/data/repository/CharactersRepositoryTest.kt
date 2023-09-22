package com.nicomahnic.data.repository

import com.nicomahnic.domain.repository.CharactersRepository
import com.nicomahnic.data.datasource.CharactersDataSource
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify

@ExtendWith(MockitoExtension::class)
class CharactersRepositoryTest{

    private lateinit var charactersRepository: CharactersRepository

    @Mock
    private lateinit var dataSource: CharactersDataSource

    @BeforeEach
    fun setup() {
        charactersRepository = CharactersRepositoryImpl(
            dataSource = dataSource
        )
    }

    @Test
    fun `check getAllCharacters is called`() {
        runBlocking{
            charactersRepository.getAllCharacters()

            verify(dataSource).getAllCharacters()
        }
    }

    @Test
    fun `check searchCharacters is called`() {
        runBlocking{
            charactersRepository.searchCharacters(ANY_STRING)

            verify(dataSource).searchCharacters(ANY_STRING)
        }
    }

    @Test
    fun `check getCharacterById is called`() {
        runBlocking{
            charactersRepository.getCharacterById(ANY_INT)

            verify(dataSource).getCharacterById(ANY_INT)
        }
    }

    companion object {
        private const val ANY_STRING = "ANY_STRING"
        private const val ANY_INT = 0
    }

}