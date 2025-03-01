package com.example.travellapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.travellapp.ui.theme.Dimens

@Composable
fun FilterTabs() {
    val tabs = listOf("Самые\nпросматриваемые", "Рядом", "Последнее")
    var selectedTab by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.padding(top = Dimens.PaddingMedium, bottom = Dimens.PaddingMedium, start = Dimens.PaddingSmall),
        horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSmall)
    ) {
        items(tabs.size) { index ->
            Button(
                onClick = { selectedTab = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == index) Color.DarkGray else Color.LightGray
                ),
                shape = RoundedCornerShape(Dimens.PaddingMedium)
            ) {
                Text(text = tabs[index], color = if (selectedTab == index) Color.White else Color.Black)
            }
        }
    }
}