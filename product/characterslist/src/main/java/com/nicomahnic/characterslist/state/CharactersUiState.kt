package com.nicomahnic.characterslist.state

import com.nicomahnic.domain.model.Character

data class CharactersUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val characters: List<Character> = emptyList()
)