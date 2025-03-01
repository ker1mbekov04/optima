package com.example.travellapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travellapp.R
import com.example.travellapp.models.Place
import com.example.travellapp.ui.theme.Dimens

@Composable
fun PlaceCardDt(place: Place, navController: NavController) {
    val placeName = stringResource(id = place.nameResId)
    val placeLocation = stringResource(id = place.locationResId)
    var isDownload by remember { mutableStateOf(false) }
    var isBack by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.ImageHeight)
            .padding(Dimens.PaddingSmall)
    ) {
        // Фоновое изображение
        Image(
            painter = painterResource(id = place.image),
            contentDescription = placeName,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(Dimens.CornerRadius))
        )

        // Кнопка назад
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(Dimens.PaddingSmall)
                .background(
                    if (isBack) Color.Black else Color.Black.copy(alpha = 0.3f),
                    CircleShape
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Назад",
                    modifier = Modifier.size(Dimens.IconSize)
                )
            }
        }

        // Кнопка скачать
        IconButton(
            onClick = { isDownload = !isDownload },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(Dimens.PaddingSmall)
                .background(
                    if (isDownload) Color.Black else Color.Black.copy(alpha = 0.3f),
                    CircleShape
                )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = "Сохранено",
                    modifier = Modifier.size(Dimens.PaddingExtraLarge)
                )
            }
        }

        // Затемнённый фон для информации
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(Dimens.CornerRadius))
                .padding(Dimens.PaddingMedium)
        ) {
            Column {
                Text(
                    text = placeName,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = placeLocation,
                        fontSize = 18.sp,
                        color = Color.LightGray
                    )
                    Text(
                        text = "Цена: $${place.price}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(Dimens.SpacerHeight))
            }
        }
    }

}
