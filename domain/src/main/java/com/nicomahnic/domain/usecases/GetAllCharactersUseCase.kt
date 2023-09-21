package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharacterModel
import com.nicomahnic.domain.repository.CharactersRepository

class GetAllCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke() : Result<List<CharacterModel>> {
        return repository.getAllCharacters()
    }
}