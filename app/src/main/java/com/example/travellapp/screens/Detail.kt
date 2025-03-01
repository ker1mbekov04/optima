package com.example.travellapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.travellapp.R
import com.example.travellapp.components.BtnBooked
import com.example.travellapp.components.InfoDt
import com.example.travellapp.components.PlaceCardDt
import com.example.travellapp.components.TimTempRat
import com.example.travellapp.models.Place
import com.example.travellapp.ui.theme.Dimens
import com.example.travellapp.ui.theme.PriceConstants
import com.example.travellapp.ui.theme.RatingConstants

@Composable
fun Detail(place: Place, navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = Dimens.PaddingMedium)
    ) {

        PlaceCardDt(place, navController)

        Spacer(modifier = Modifier.height(Dimens.SpacerHeight))

        TimTempRat(place)

        Spacer(modifier = Modifier.height(Dimens.SpacerHeight))

        InfoDt(place)

        Spacer(modifier = Modifier.weight(1f))

        BtnBooked()
    }
}

fun getPlaceById(id: Int): Place {
    val places = listOf(
        Place(
            id = 1,
            nameResId = R.string.place_fuji_name,
            locationResId = R.string.place_fuji_location,
            rating = RatingConstants.FUJI_RATING,
            price = PriceConstants.FUJI_PRICE,
            image = R.drawable.fuji,
            descriptionResId = R.string.place_fuji_description,
            timeResId = R.string.place_fuji_time,
            gradusResId = R.string.place_fuji_temp
        ),
        Place(
            id = 2,
            nameResId = R.string.place_andy_name,
            locationResId = R.string.place_andy_location,
            rating = RatingConstants.ANDY_RATING,
            price = PriceConstants.ANDY_PRICE,
            image = R.drawable.andy,
            descriptionResId = R.string.place_andy_description,
            timeResId = R.string.place_andy_time,
            gradusResId = R.string.place_andy_temp
        )
    )
    return places.find { it.id == id } ?: places[0]
}

@Preview
@Composable
fun DetailPreview() {
    val place = getPlaceById(1)
    val navController = rememberNavController()
    Detail(place = place, navController = navController)
}