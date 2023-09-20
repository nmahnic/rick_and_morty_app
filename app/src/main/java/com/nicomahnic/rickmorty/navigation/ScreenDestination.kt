package com.nicomahnic.rickmorty.navigation

import com.nicomahnic.landing.ScreenInfo

sealed interface ScreenDestination {
    val route: String
    val info: ScreenInfo
}