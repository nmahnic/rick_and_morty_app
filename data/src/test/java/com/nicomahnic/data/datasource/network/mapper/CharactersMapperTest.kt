package com.nicomahnic.data.datasource.network.mapper

import com.nicomahnic.data.datasource.network.model.CharacterNetworkObjectMother
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CharactersMapperTest {

    private lateinit var charactersMapper: CharactersMapper

    @BeforeEach
    fun setup() {
        charactersMapper = CharactersMapperImpl()
    }

    @Test
    fun `map characters from network to model`(){
        val expectedResult = CharacterNetworkObjectMother.mockSomeCharactersModels()
        val entity = CharacterNetworkObjectMother.mockCharactersEntityResponse()
        val result = charactersMapper.toListModel(entity)

        assert(result == expectedResult)
    }

    @Test
    fun `map character from network to model`(){
        val expectedResult = CharacterNetworkObjectMother.mockCharacterModel()
        val entity = CharacterNetworkObjectMother.mockCharacterEntityResponse()
        val result = charactersMapper.toModel(entity)

        assert(result == expectedResult)
    }
}