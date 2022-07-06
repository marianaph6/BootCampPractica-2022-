package com.example.imbd.network

import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.network.responses.TopRatedMovieSearchResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TopRatedMovieService {


    @GET("movie/top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")
    fun get_top_rated_movies(
        //@Header("api_key") api_key: String
    ): Call<TopRatedMovieSearchResponse>



}