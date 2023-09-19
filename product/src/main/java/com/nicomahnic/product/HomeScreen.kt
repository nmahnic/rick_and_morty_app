package com.nicomahnic.product

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ){
        Text("HOME SCREEN")
    }
}