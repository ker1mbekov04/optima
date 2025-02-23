package com.example.travellapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen {
                navController.navigate("main")
            }
        }
        composable("main") {
            MainScreen (navController)
        }
        composable("recent"){
            RecentScreen(navController)
        }
        composable("favorite"){
            FavoriteScreen(navController)
        }

        composable("profile"){
            ProfileScreen(navController)
        }
        composable(
            "detail/{placeId}",
            arguments = listOf(navArgument("placeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments?.getInt("placeId") ?: 0
            val place = getPlaceById(placeId)
            Detail(place, navController)
        }
    }
}

