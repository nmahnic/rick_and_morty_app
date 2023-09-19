package com.nicomahnic.domain.usecases

import com.nicomahnic.domain.repository.CharactersRepository
class GetAllCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke() {
        println("LLEGUE AL USECASE")
        repository.getAllCharacters()
    }
}