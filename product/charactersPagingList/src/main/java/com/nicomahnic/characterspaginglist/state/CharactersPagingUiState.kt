package com.nicomahnic.characterspaginglist.state

import com.nicomahnic.domain.model.Character

data class CharactersPagingUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val characters: List<Character> = emptyList()
)