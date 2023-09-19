package com.nicomahnic.rickymorty.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

object CharacterDetailsDestination : ScreenDestination {
    private const val arg: String = "rick"

    override val route: String = "characterdetails/{$arg}"

    val arguments = listOf(
        navArgument(arg) { type = NavType.StringType }
    )

    fun createNavRoute(cast: String) = "characterdetails/$cast"

    fun NavBackStackEntry.componentNavArg(): String? = arguments?.getString(arg)
}