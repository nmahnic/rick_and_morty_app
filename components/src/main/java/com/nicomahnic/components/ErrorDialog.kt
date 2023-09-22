package com.nicomahnic.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nicomahnic.component.R

@Composable
fun ErrorDialog(
    onRetry: () -> Unit
){
    AlertDialog(
        onDismissRequest = { },
        title = {
            Text(text = "Fetch Error")
        },
        icon = {
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .padding(4.dp)
                    .aspectRatio(1.0f)
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(id = R.drawable.baseline_error_outline_24),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
        },
        confirmButton = {
            Button(
                onClick = onRetry ){
                Text(text = "Retry")
            }
        }
    )
}