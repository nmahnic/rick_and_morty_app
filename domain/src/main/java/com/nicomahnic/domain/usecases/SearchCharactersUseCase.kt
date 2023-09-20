package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.repository.CharactersRepository

class SearchCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(inputSearch: String) : Result<CharactersNetwork> {
        return repository.searchCharacters(inputSearch)
    }
}