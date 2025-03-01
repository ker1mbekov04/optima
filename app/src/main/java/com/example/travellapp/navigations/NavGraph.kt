package com.example.travellapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.travellapp.screens.Detail
import com.example.travellapp.screens.FavoriteScreen
import com.example.travellapp.screens.MainScreen
import com.example.travellapp.screens.ProfileScreen
import com.example.travellapp.screens.RecentScreen
import com.example.travellapp.screens.SplashScreen
import com.example.travellapp.screens.getPlaceById


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

