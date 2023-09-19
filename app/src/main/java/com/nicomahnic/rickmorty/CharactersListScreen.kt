
package com.nicomahnic.rickmorty

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharactersListScreen(
    onCharacterClick: (String) -> Unit
) {
    Button(
        onClick = { onCharacterClick("Prueba") }
    ){
        Text("CHARACTERS LIST SCREEN")
    }
}