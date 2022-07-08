package com.example.imbd.network.TopRatedMovie


import com.example.imbd.domain.model.TopRatedMovie

data class TopRatedMovieSearchResponse (

    var page: Int,
    var results: List<TopRatedMovie>


)