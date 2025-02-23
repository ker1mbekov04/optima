package com.example.travellapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onNavigate: () -> Unit) {

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF0172B2), Color(0xFF001645)), // Верхний и нижний цвета
        startY = 0f, // Начало градиента (верх)
        endY = Float.POSITIVE_INFINITY // Конец градиента (низ)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Text(
                    text = "Travel",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.fonts)), // Шрифт
                        fontSize = 44.sp,
                        color = Color.White
                    )
                )
                Image(
                    painter = painterResource(R.drawable.globe),
                    contentDescription = "Earth Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            // Подзаголовок
            Text(
                text = "Найдите место своей\nмечты вместе с нами",
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }

        // Переход
        LaunchedEffect(Unit) {
            delay(3000)
            onNavigate()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(onNavigate = {})
}
