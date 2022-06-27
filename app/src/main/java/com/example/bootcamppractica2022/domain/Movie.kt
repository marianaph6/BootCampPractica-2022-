package com.example.imbd.domain

data class Movie(
    val url: String,
    val title: String,
    val year: Short,
    val actors: List<String>
)