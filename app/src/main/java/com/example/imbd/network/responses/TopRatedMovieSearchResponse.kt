package com.example.imbd.network.responses


import com.example.imbd.network.model.TopRatedMovieNetworkEntity
import com.google.gson.annotations.SerializedName

data class TopRatedMovieSearchResponse (

    @SerializedName("results")
    var top_rated_movies: List<TopRatedMovieNetworkEntity>


)