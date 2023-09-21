package com.nicomahnic.domain.model

object CharactersObjectMother {

    fun mockModel() = CharacterModel()

    fun mockSomeModels(items: Int = 6) = getSome(items) {
        mockModel()
    }
}