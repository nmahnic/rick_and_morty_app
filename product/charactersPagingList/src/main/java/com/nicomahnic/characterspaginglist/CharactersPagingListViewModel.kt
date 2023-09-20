package com.nicomahnic.characterspaginglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nicomahnic.domain.model.Character
import com.nicomahnic.domain.usecases.GetAllPagedCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class CharactersPagingListViewModel(
    private val getAllPagedCharactersUseCase: GetAllPagedCharactersUseCase
): ViewModel() {

    private val _uiPagingState: MutableStateFlow<PagingData<Character>> = MutableStateFlow(value = PagingData.empty())
    val uiPagingState: MutableStateFlow<PagingData<Character>> get() = _uiPagingState


    init {
        viewModelScope.launch {
            getAllPagedCharactersUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _uiPagingState.value = it
                }
        }
    }
}