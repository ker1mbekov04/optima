package com.example.travellapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(20.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Привет, Нурбек \uD83D\uDC4B",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }
            Text(
                text = "Исследуйте мир",
                fontSize = 22.sp,
                color = Color.Gray
            )
            SearchBar()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    onClick = { /* TODO: */ },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(IntrinsicSize.Min),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) {
                    Text(text = "Популярные места", color = Color.White)
                }

                Button(
                    onClick = { /* TODO: */ },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .height(IntrinsicSize.Min),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                ) {
                    Text(text = "Все", color = Color.White)
                }


            }
            FilterTabs()
            PlacesListScreen(navController = navController)
        }
    }
}
@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text(
                text = "Поиск мест...",
                fontSize = 16.sp,
                color = Color.Gray
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.LightGray
        ),
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
    )
}

@Composable
fun FilterTabs() {
    val tabs = listOf("Самые\nпросматриваемые", "Рядом", "Последнее")
    var selectedTab by remember { mutableStateOf(0) }

    LazyRow(
        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp, start = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tabs.size) { index ->
            Button(
                onClick = { selectedTab = index },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedTab == index) Color.DarkGray else Color.LightGray
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = tabs[index],
                    color = if (selectedTab == index) Color.White else Color.Black
                )
            }
        }
    }
}

@Composable
fun PlacesListScreen(navController: NavController) {
    val places = remember {
        listOf(
            Place(
                id = 1,
                name = "Гора Фудзи",
                location = "Токио, Япония",
                rating = 4.8f,
                price = 270,
                image = R.drawable.fuji,
                description = "Гора Фудзи — это один из самых знаковых пейзажей Японии, символизирующий силу и гармонию природы. Ее заснеженная вершина возвышается на 3776 метров, притягивая альпинистов и фотографов со всего мира. Весной подножие Фудзи утопает в цветущей сакуре, а осенью покрывается яркими оттенками кленовых листьев. Здесь можно насладиться традиционными онсэнами, исследовать древние храмы и испытать себя на захватывающих маршрутах восхождения.",
                time = "8 часов",
                gradus = "16°C"
            ),
            Place(
                id = 2,
                name = "Гора Анды",
                location = "Южная Америка",
                rating = 4.5f,
                price = 230,
                image = R.drawable.andy,
                description = "Горная цепь Анды — это величественное природное чудо, растянувшееся на 7000 километров через несколько стран Южной Америки. Здесь находятся самые высокие вершины за пределами Азии, среди которых Аконкагуа (6961 м). Эти горы хранят следы древних цивилизаций, включая таинственные руины инков, а также священные дороги, ведущие в легендарный Мачу-Пикчу. В Андах можно встретить потрясающее разнообразие климатических зон — от заснеженных вершин до пышных тропических лесов. ",
                time = "11 часов",
                gradus = "9°C"
            )
        )
    }

    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(places) { place ->
            PlaceCard(place = place, navController = navController)
        }
    }
}

@Composable
fun PlaceCard(place: Place, navController: NavController) {
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .width(270.dp)
            .height(400.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate("detail/${place.id}")
            },
        shape = RoundedCornerShape(16.dp),
    ) {
        Box {
            // Фоновое изображение
            Image(
                painter = painterResource(place.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Кнопка "избранное"
            IconButton(
                onClick = {
                    isFavorite = !isFavorite
                },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(
                        if (isFavorite) Color.Red else Color.Black.copy(alpha = 0.3f),
                        CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Избранное",
                    tint = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column {
                    // Название
                    Text(
                        text = place.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Локация
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.location),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                        Text(
                            text = place.location,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Рейтинг
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "%.1f".format(place.rating),
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}