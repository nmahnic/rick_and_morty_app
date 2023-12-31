package com.nicomahnic.characterslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nicomahnic.components.CharacterItem
import com.nicomahnic.components.ErrorDialog
import com.nicomahnic.components.InputText
import com.nicomahnic.components.ShimmerAnimation
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersListScreen(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharactersListViewModel = koinViewModel(),
) {
    val charactersState by viewModel.uiState.collectAsState()

    if(charactersState.isError) {
        ErrorDialog { viewModel.initialize() }
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InputText {
                viewModel.searchCharacters(it)
            }

            LazyColumn {

                items(charactersState.characters) {
                    CharacterItem(it, onCharacterClick)
                }

                if (charactersState.isLoading) {
                    repeat((0..10).count()) {
                        item { ShimmerAnimation() }
                    }
                }

            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }
}