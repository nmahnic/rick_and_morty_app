package com.nicomahnic.rickmorty.navigation

import com.nicomahnic.landing.ScreenInfo

object CharactersPagingListDestination: ScreenDestination {
    override val route: String = "characterpaginglist"

    override val info: ScreenInfo = ScreenInfo(
        route = route,
        title = "Characters wit paging"
    )
}