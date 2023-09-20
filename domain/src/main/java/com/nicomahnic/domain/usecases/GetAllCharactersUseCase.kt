package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.model.CharactersNetwork
import com.nicomahnic.domain.repository.CharactersRepository

class GetAllCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke() : Result<CharactersNetwork> {
        return repository.getAllCharacters()
    }
}