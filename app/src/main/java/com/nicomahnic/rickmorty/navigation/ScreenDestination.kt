package com.nicomahnic.rickmorty.navigation

sealed interface ScreenDestination {
    val route: String
}