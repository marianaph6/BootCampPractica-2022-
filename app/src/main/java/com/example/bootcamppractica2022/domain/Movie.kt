package com.example.bootcamppractica2022.domain

data class Movie(
    val url: String,
    val title: String,
    val year: Short,
    val actors: List<String>
)