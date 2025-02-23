package com.example.travellapp

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(route = "main", icon = R.drawable.home),
        BottomNavItem(route = "recent", icon = R.drawable.time),
        BottomNavItem(route = "favorite", icon = R.drawable.like),
        BottomNavItem(route = "profile", icon = R.drawable.profile_2)
    )

    NavigationBar(
        containerColor = Color.White
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = false,
                onClick = { navController.navigate(item.route) }
            )
        }
    }
}
