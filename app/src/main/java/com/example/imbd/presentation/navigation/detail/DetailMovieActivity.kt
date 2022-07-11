package com.example.imbd.presentation.navigation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.imbd.R
import com.example.imbd.databinding.ActivityDetailMovieBinding
import com.example.imbd.databinding.ActivityMainBinding
import com.example.imbd.domain.model.ComicBookMovie
import com.example.imbd.domain.model.TopRatedMovie

class DetailMovieActivity : AppCompatActivity() {

    private var _binding: ActivityDetailMovieBinding? = null
    private val binding get() = _binding!!
    private lateinit var type: String
    private lateinit var topRatedMovie: TopRatedMovie
    private lateinit var comicBookMovie: ComicBookMovie
    private var movie= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        print("onCreate")
    }

    override fun onStart() {
        super.onStart()
        print("onStart")

        type= intent.getStringExtra("Type").toString()
    }

    override fun onResume() {
        super.onResume()
        with(binding){
            when(type){
                "TopRatedMovie"-> {
                    topRatedMovie = (intent.getSerializableExtra("TopRatedMovie") as? TopRatedMovie)!!
                    txDescriptionMovieTitleDetail.text=topRatedMovie.title
                    textViewDetailMovieStar.text=topRatedMovie.vote_average.toString()
                    txDescriptionMoviePortadaDetail.text= topRatedMovie.overview
                    Glide.with(this@DetailMovieActivity).load("https://image.tmdb.org/t/p/w500/"+topRatedMovie.backdrop_path).into((ivPortadaMovieDetail))
                    Glide.with(this@DetailMovieActivity).load("https://image.tmdb.org/t/p/w500/"+topRatedMovie.poster_path).into((ivPosterMovieDetail))

                }
                "ComicBookMovie" -> {
                    comicBookMovie = (intent.getSerializableExtra("ComicBookMovie") as? ComicBookMovie)!!
                    txDescriptionMovieTitleDetail.text=comicBookMovie.title
                    textViewDetailMovieStar.text=comicBookMovie.vote_average.toString()
                    txDescriptionMoviePortadaDetail.text= comicBookMovie.overview
                    Glide.with(this@DetailMovieActivity).load("https://image.tmdb.org/t/p/w500/"+comicBookMovie.backdrop_path).into((ivPortadaMovieDetail))
                    Glide.with(this@DetailMovieActivity).load("https://image.tmdb.org/t/p/w500/"+comicBookMovie.poster_path).into((ivPosterMovieDetail))

                }
                else -> {

                }
            }

        }
        print("onResume")
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        print("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        print("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        print("onDestroy")
    }

    private fun print(msg: String){
        Log.d("Activity State ",msg)
    }
}