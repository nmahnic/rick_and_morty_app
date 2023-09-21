package com.nicomahnic.domain.usecases

import androidx.paging.PagingData
import com.nicomahnic.domain.repository.CharactersRepository
import com.nicomahnic.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class GetAllPagedCharactersUseCase(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke() : Flow<PagingData<CharacterModel>> {
        return repository.getAllPagedCharacters()
    }
}