package com.nicomahnic.charactersdetails.state

import com.nicomahnic.domain.model.Character

data class CharacterUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val character: Character = Character()
)