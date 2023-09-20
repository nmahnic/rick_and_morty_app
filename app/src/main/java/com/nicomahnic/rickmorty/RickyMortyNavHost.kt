package com.nicomahnic.rickmorty

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nicomahnic.charactersdetails.CharacterDetailsScreen
import com.nicomahnic.characterslist.CharactersListScreen
import com.nicomahnic.landing.HomeScreen
import com.nicomahnic.rickmorty.navigation.CharacterDetailsDestination
import com.nicomahnic.rickmorty.navigation.CharacterDetailsDestination.componentNavArg
import com.nicomahnic.rickmorty.navigation.CharactersListDestination
import com.nicomahnic.rickmorty.navigation.HomeDestination

@Composable
fun RickMortyNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeDestination.route) {
        homeDestination(navController)
        charactersListDestination(navController)
        characterDetailsDestination()
    }
}

private fun NavGraphBuilder.homeDestination(navController: NavHostController) {
    composable(HomeDestination.route) {
        HomeScreen(
            onClick = {
                navController.navigate(
                    CharactersListDestination.route
                )
            }
        )
    }
}

private fun NavGraphBuilder.charactersListDestination(navController: NavHostController) {
    composable(CharactersListDestination.route) {
        CharactersListScreen(
            onCharacterClick = { characterId ->
                Log.e("NM", "NAVIGATE FROM LIST TO HOME (characterID = $characterId)")
                navController.navigate(
                    CharacterDetailsDestination.createNavRoute(characterId)
                )
            }
        )
    }
}

private fun NavGraphBuilder.characterDetailsDestination() {
    composable(
        route = CharacterDetailsDestination.route,
        arguments = CharacterDetailsDestination.arguments
    ) { backStackEntry ->
        val characterId = backStackEntry.componentNavArg()
        characterId?.let {
            CharacterDetailsScreen(
                id = it,
            )
        }
    }
}