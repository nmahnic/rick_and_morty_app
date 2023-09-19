package com.nicomahnic.rickymorty.navigation

sealed interface ScreenDestination {
    val route: String
}