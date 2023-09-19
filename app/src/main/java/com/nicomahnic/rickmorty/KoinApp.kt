package com.nicomahnic.rickmorty

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun KoinApp() {
    KoinAndroidContext {
        RickMortyNavHost()
    }
}