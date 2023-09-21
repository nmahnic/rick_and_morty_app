package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharacterModel
import com.nicomahnic.domain.repository.CharactersRepository

class GetCharacterByIdUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(id: Int) : Result<CharacterModel> {
        return repository.getCharacterById(id)
    }
}