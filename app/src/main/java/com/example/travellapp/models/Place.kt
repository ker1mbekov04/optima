package com.example.travellapp.models

data class Place(
    val id: Int,
    val nameResId: Int,
    val locationResId: Int,
    val rating: Float,
    val price: Int,
    val image: Int,
    val descriptionResId: Int,
    val timeResId: Int,
    val gradusResId: Int
)
