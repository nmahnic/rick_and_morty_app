
package com.nicomahnic.characterspaginglist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.nicomahnic.components.CharacterItem
import com.nicomahnic.domain.model.Character
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersPagingListScreen(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharactersPagingListViewModel = koinViewModel(),
) {
    val charactersPagingItems: LazyPagingItems<Character> =
        viewModel.uiState.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(charactersPagingItems.itemCount) { index ->
            CharacterItem(charactersPagingItems[index]!!, onCharacterClick)
        }

    }
}