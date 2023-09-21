package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharacterModel
import com.nicomahnic.domain.repository.CharactersRepository

class SearchCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(inputSearch: String) : Result<List<CharacterModel>> {
        return repository.searchCharacters(inputSearch)
    }
}