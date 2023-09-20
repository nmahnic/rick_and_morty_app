package com.nicomahnic.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.nicomahnic.domain.model.Character

@Composable
fun CharacterItem(
    character: Character,
    onCharacterClick: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {  onCharacterClick(character.id) }
    ) {
        Row(
            Modifier
                .padding(all = 4.dp)
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(
                    model = character.image
                ),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )

            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = character.status,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.LightGray
                    ),
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.6.sp
                )
            }
        }
    }
}
