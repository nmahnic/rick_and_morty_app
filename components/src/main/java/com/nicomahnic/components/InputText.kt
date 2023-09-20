package com.nicomahnic.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    inputValue: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
    ){
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                inputValue(it)
            },
            modifier = modifier
                .fillMaxWidth(),
            placeholder = { Text("Search") }
        )
    }
}