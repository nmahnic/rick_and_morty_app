package com.nicomahnic.charactersdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.charactersdetails.state.CharacterUiState
import com.nicomahnic.domain.usecases.GetCharacterByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()


    fun getCharacterById(id: Int) {
        viewModelScope.launch {
            _uiState.value = CharacterUiState(isLoading = true)
            getCharacterByIdUseCase(id).onSuccess {
                Log.e("NM", "VIEWMODEL SUCCESS $it")
                _uiState.value = CharacterUiState(
                    character = it,
                    isLoading = false
                )
            }.onFailure {
                Log.e("NM", "VIEWMODEL ERROR")
                _uiState.value = CharacterUiState(isError = true)
            }
        }
    }
}