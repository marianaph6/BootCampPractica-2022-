package com.example.imbd.network.ComicBookMovie

import com.example.imbd.domain.model.ComicBookMovie
import com.example.imbd.network.TopRatedMovie.TopRatedMovieSearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val  BASE_URL= "https://api.themoviedb.org/3/"
const val API_KEY = "c5c47722a4adcc77f6e84f28a48b857a"
const val LANGUAJE= "en-US"
interface ComicBookMovieInterface {


    @GET("list/1?api_key=$API_KEY")
    fun getComicBookMovies(
        //@Query("api_key") api_key: String
    ): Call<ComicBookMovieSearchResponse>
}

object ComicBookMovieService{
    val comicBookMovieInstance: ComicBookMovieInterface
    init {
        val retrofit: Retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        comicBookMovieInstance= retrofit.create(ComicBookMovieInterface::class.java)
    }
}