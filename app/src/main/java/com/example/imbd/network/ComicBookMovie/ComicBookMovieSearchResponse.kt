package com.example.imbd.network.ComicBookMovie


import com.example.imbd.domain.model.ComicBookMovie

data class ComicBookMovieSearchResponse (

    var created_by: String,
    var description: String,
    var favorite_count: Int,
    var id: String,
    var items: List<ComicBookMovie>,
    var item_count: Int,
    var iso_639_1: String,
    var name: String,
    var poster_path: String


)