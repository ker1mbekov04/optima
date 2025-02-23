package com.example.travellapp

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Detail(place: Place, navController: NavController) {
    var isDownland by remember { mutableStateOf(false) }
    var isBack by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(440.dp)
                .padding(15.dp)
        ) {


            // Фоновое изображение
            Image(
                painter = painterResource(id = place.image),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )

            IconButton(
                onClick = {navController.popBackStack()},
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .background(
                        if (isBack) Color.Black else Color.Black.copy(alpha = 0.3f),
                        CircleShape
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.back),
                        contentDescription = "Назад",
                        modifier = Modifier.size(24.dp)
                    )

                }
            }

            IconButton(
                onClick = { isDownland = !isDownland},
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(
                        if (isDownland) Color.Black else Color.Black.copy(alpha = 0.3f),
                        CircleShape
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img),
                        contentDescription = "Сохранено",
                        modifier = Modifier.size(24.dp)
                    )

                }
            }


            // Затемнённый фон для информации
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = place.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,) {
                        Text(
                            text = place.location,
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

                    Spacer(modifier = Modifier.height(8.dp))

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = place.time,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp)) // Добавляем промежуток
            Text(
                text = place.gradus,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "%.1f".format(place.rating),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Описание
        Text(
            text = place.description,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(16.dp)
        )

        // Кнопка
        Spacer(modifier = Modifier.weight(1f)) // Раздвигает контент вверх

        Button(
            onClick = { /* TODO: Добавить логику бронирования */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Забронировать сейчас", color = Color.White)
        }
    }
}

fun getPlaceById(id: Int): Place {
    val places = listOf(
        Place(1,
            "Гора Фудзи",
            "Токио, Япония",
            4.8f,
            270,
            R.drawable.fuji,
            "Гора Фудзи — это один из самых знаковых и почитаемых природных объектов Японии, символизирующий силу, красоту и гармонию природы. Этот величественный вулкан с идеально симметричным конусом возвышается на 3776 метров и является самой высокой горой в стране.\n" +
                    "\n",
            time = "8 часов",
            gradus = "16°C"
        ),

        Place(2,
            "Гора Анды",
            "Южная Америка",
            4.5f,
            230,
            R.drawable.andy,
            description = "Горная цепь Анды — это величественное природное чудо, растянувшееся на 7000 километров через несколько стран Южной Америки. Здесь находятся самые высокие вершины за пределами Азии, среди которых Аконкагуа (6961 м).",
            time = "8 часов",
            gradus = "16°C")
    )
    return places.find { it.id == id } ?: places[0]
}
@Preview
@Composable
fun DetailPreview() {
    val place = getPlaceById(1)
    val navController = rememberNavController()
    Detail(place, navController = navController)
}