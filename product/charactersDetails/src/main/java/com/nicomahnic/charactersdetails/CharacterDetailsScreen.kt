
package com.nicomahnic.charactersdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.nicomahnic.components.CharacterDetail
import com.nicomahnic.components.ErrorDialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailsScreen(
    id: Int,
    viewModel: CharacterDetailsViewModel = koinViewModel(),
) {
    val characterState by viewModel.uiState.collectAsState()

    if(characterState.isError){
        ErrorDialog { viewModel.getCharacterById(id) }
    } else {
        CharacterDetail(characterState.character)
    }

    LaunchedEffect(Unit){
        viewModel.getCharacterById(id)
    }
}