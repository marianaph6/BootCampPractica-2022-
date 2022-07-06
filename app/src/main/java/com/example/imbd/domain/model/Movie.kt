package com.example.imbd.domain.model

data class Movie(
    val url: String,
    val title: String,
    val year: Short,
    val actors: List<String>
)

