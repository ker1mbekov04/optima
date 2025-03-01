package com.example.travellapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.travellapp.R
import com.example.travellapp.components.PlaceCard
import com.example.travellapp.components.SearchBar
import com.example.travellapp.components.FilterTabs
import com.example.travellapp.models.Place
import com.example.travellapp.navigations.BottomNavigationBar
import com.example.travellapp.ui.theme.*

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(Dimens.PaddingLarge),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Привет, Нурбек 👋",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .size(Dimens.IconSize)
                        .clip(CircleShape)
                )
            }
            Text(text = "Исследуйте мир", fontSize = 22.sp, color = Color.Gray)
            SearchBar()
            FilterTabs()
            PlacesListScreen(navController)
        }
    }
}

@Composable
fun PlacesListScreen(navController: NavController) {
    val places = listOf(
        Place(
            id = 1, nameResId = R.string.place_fuji_name,
            locationResId = R.string.place_fuji_location,
            rating = RatingConstants.FUJI_RATING,
            price = PriceConstants.FUJI_PRICE,
            image = R.drawable.fuji,
            descriptionResId = R.string.place_fuji_description,
            timeResId = R.string.place_fuji_time,
            gradusResId = R.string.place_fuji_temp
        ),
        Place(
            id = 2, nameResId = R.string.place_andy_name,
            locationResId = R.string.place_andy_location,
            rating = RatingConstants.ANDY_RATING,
            price = PriceConstants.ANDY_PRICE,
            image = R.drawable.andy,
            descriptionResId = R.string.place_andy_description,
            timeResId = R.string.place_andy_time,
            gradusResId = R.string.place_andy_temp
        )
    )

    LazyRow(horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)) {
        items(places) { place ->
            PlaceCard(place, navController)
        }
    }
}



@Preview
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}