package com.nicomahnic.characterslist.state

import com.nicomahnic.domain.model.CharacterModel

data class CharactersUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val characters: List<CharacterModel> = emptyList()
)