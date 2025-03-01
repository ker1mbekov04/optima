package com.example.travellapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travellapp.R
import com.example.travellapp.models.Place
import com.example.travellapp.ui.theme.Dimens

@Composable
fun PlaceCard(place: Place, navController: NavController) {
    var isFavorite by remember { mutableStateOf(false) }

    val placeName = stringResource(id = place.nameResId)
    val placeLocation = stringResource(id = place.locationResId)

    Card(
        modifier = Modifier
            .width(Dimens.CardWidth)
            .height(Dimens.CardHeight)
            .padding(Dimens.PaddingSmall)
            .clickable { navController.navigate("detail/${place.id}") },
        shape = RoundedCornerShape(Dimens.PaddingMedium),
    ) {
        Box {
            Image(
                painter = painterResource(place.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(Dimens.PaddingSmall)
                    .background(if (isFavorite) Color.Red else Color.Black.copy(alpha = 0.3f), CircleShape)
            ) {
                Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Избранное", tint = Color.White)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
                    .padding(Dimens.PaddingMedium)
            ) {
                Column {
                    Text(text = placeName, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)

                    Spacer(modifier = Modifier.height(Dimens.PaddingSmall))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.location), contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.White)
                        Text(text = placeLocation, fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(start = Dimens.PaddingSmall))
                    }
                }
            }
        }
    }
}