package com.nicomahnic.characterslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.characterslist.state.CharactersUiState
import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(CharactersUiState())
    val uiState: StateFlow<CharactersUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.value = CharactersUiState(isLoading = true)
            getAllCharactersUseCase().onSuccess {
                _uiState.value = CharactersUiState(
                    characters = it.results,
                    isLoading = false
                )
            }.onFailure {
                Log.e("NM", "VIEWMODEL ERROR")
                _uiState.value = CharactersUiState(isError = true)
            }
        }
    }
}