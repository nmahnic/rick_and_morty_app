package com.nicomahnic.rickmorty.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

object CharacterDetailsDestination : ScreenDestination {
    private const val arg: String = "id"

    override val route: String = "characterdetails/{$arg}"

    val arguments = listOf(
        navArgument(arg) { type = NavType.IntType }
    )

    fun createNavRoute(id: Int) = "characterdetails/$id"

    fun NavBackStackEntry.componentNavArg(): Int? = arguments?.getInt(arg)
}