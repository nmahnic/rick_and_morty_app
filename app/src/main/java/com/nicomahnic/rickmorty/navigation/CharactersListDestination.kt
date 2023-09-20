package com.nicomahnic.rickmorty.navigation

import com.nicomahnic.landing.ScreenInfo

object CharactersListDestination: ScreenDestination {
    override val route: String = "characterlist"

    override val info: ScreenInfo = ScreenInfo(
        route = route,
        title = "Characters without paging"
    )
}