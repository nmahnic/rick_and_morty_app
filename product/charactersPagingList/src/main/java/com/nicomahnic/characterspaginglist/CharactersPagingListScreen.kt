package com.nicomahnic.characterspaginglist

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.nicomahnic.components.CharacterItem
import com.nicomahnic.components.ErrorDialog
import com.nicomahnic.components.Loader
import com.nicomahnic.components.ShimmerAnimation
import com.nicomahnic.domain.model.CharacterModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharactersPagingListScreen(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharactersPagingListViewModel = koinViewModel(),
) {
    val charactersPagingItems: LazyPagingItems<CharacterModel> =
        viewModel.uiPagingState.collectAsLazyPagingItems()

    when {
        charactersPagingItems.loadState.prepend is LoadState.Error -> {
            ErrorDialog { viewModel.initialize() }
        }
        charactersPagingItems.loadState.refresh is LoadState.Error -> {
            ErrorDialog { viewModel.initialize() }
        }
        charactersPagingItems.loadState.append is LoadState.Error -> {
            ErrorDialog { viewModel.initialize() }
        }
    }

    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (charactersPagingItems.loadState.prepend is LoadState.Loading) {
                item { Loader("loadState.prepend is LoadState.Loading") }
            }

            items(charactersPagingItems.itemCount) { index ->
                CharacterItem(charactersPagingItems[index]!!, onCharacterClick)
            }

            if (charactersPagingItems.loadState.refresh is LoadState.Loading) {
                Log.e("NM", "loadState.refresh is LoadState.Loading")
                repeat((0..10).count()) {
                    item {
                        ShimmerAnimation()
                    }
                }
            }

            if (charactersPagingItems.loadState.append is LoadState.Loading) {
                item { Loader("loadState.append is LoadState.Loading") }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }
}