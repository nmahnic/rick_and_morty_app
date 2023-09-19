package com.nicomahnic.characterslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicomahnic.domain.usecases.GetAllCharactersUseCase
import kotlinx.coroutines.launch

class CharactersListViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            Log.e("NM", "LLEGUE AL VIEWMODEL")
            getAllCharactersUseCase()
        }
    }
}