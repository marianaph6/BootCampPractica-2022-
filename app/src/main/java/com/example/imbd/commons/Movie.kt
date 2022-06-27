package com.example.imbd.commons

data class Movie(
    val url: String,
    val title: String,
    //val rating: Float,
    val year: Short,
    val actors: List<String>
)