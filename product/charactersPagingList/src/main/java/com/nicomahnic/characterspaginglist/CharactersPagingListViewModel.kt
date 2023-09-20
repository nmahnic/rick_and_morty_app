package com.nicomahnic.characterspaginglist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.characterspaginglist.state.CharactersPagingUiState
import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersPagingListViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(CharactersPagingUiState())
    val uiState: StateFlow<CharactersPagingUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.value = CharactersPagingUiState(isLoading = true)
            getAllCharactersUseCase().onSuccess {
                _uiState.value = CharactersPagingUiState(
                    characters = it.results,
                    isLoading = false
                )
            }.onFailure {
                Log.e("NM", "VIEWMODEL ERROR")
                _uiState.value = CharactersPagingUiState(isError = true)
            }
        }
    }
}