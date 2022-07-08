package com.example.imbd.network

import com.example.imbd.network.TopRatedMovie.TopRatedMovieSearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val  BASE_URL= "https://api.themoviedb.org/3/"
const val API_KEY = "c5c47722a4adcc77f6e84f28a48b857a"
const val LANGUAJE= "en-US"
interface TopRatedMovieInterface {


    //https://api.themoviedb.org/3/movie/top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a&language=en-US
    @GET("movie/top_rated?api_key=$API_KEY")
    fun getTopRatedMovies(

        //@Query("api_key") api_key: String
    ): Call<TopRatedMovieSearchResponse>
}

object TopRatedMovieService{
    val topRatedMovieInstance: TopRatedMovieInterface
    init {
        val retrofit: Retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        topRatedMovieInstance= retrofit.create(TopRatedMovieInterface::class.java)
    }
}