package com.nicomahnic.rickmorty.navigation

import com.nicomahnic.landing.ScreenInfo

object HomeDestination: ScreenDestination {
    override val route: String = "home"

    override val info: ScreenInfo = ScreenInfo(
        route = route,
        title = "Home"
    )
}