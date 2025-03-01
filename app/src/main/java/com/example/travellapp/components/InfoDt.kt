package com.example.travellapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.travellapp.models.Place
import com.example.travellapp.ui.theme.Dimens

@Composable
fun InfoDt(place: Place){
    val placeDescription = stringResource(id = place.descriptionResId)
    Text(
        text = placeDescription,
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = Modifier.padding(Dimens.PaddingMedium)
    )
}

