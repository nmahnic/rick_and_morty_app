
package com.nicomahnic.characterslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersListScreen(
    onCharacterClick: (String) -> Unit,
    viewModel: CharactersListViewModel = koinViewModel(),
) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onCharacterClick("NM") }
        ){
            Text("CHARACTERS LIST SCREEN")
        }
    }

}