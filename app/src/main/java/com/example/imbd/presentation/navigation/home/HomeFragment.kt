package com.example.imbd.presentation.navigation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.imbd.presentation.navigation.detail.DetailMovieActivity
import com.example.imbd.databinding.FragmentHomeBinding
import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.network.TopRatedMovie.TopRatedMovieSearchResponse
import com.example.imbd.network.TopRatedMovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), TopRatedMovieOnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: MovieLinearHorizontalAdapter

    private var data = mutableListOf<TopRatedMovie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)



        getTopRatedMovies()
        //getPosterPathMovie()

        return binding.root
    }

    private fun initListener(){


    }

    private fun getPosterPathMovie(){
        var randomMovie= ((0 until data.size).random())
        val moviePoster: TopRatedMovie= data[randomMovie]
        with(binding){
            Glide.with(this@HomeFragment).load("https://image.tmdb.org/t/p/w500/" + moviePoster.backdrop_path).into(ivPortadaMovieHome)
            Glide.with(this@HomeFragment).load("https://image.tmdb.org/t/p/w500/" + moviePoster.poster_path).into(ivPosterMovieHome)
            txTitleMovieHome.text = moviePoster.title
        }

    }


    private fun getTopRatedMovies(){

        val topMovieSearchResponse= TopRatedMovieService.topRatedMovieInstance.getTopRatedMovies()
        topMovieSearchResponse.enqueue(object : Callback<TopRatedMovieSearchResponse>{
            override fun onFailure(call: Call<TopRatedMovieSearchResponse>, t: Throwable) {
                Log.d("IMBD", "Error cargando las peliculas", t)
            }

            override fun onResponse(
                call: Call<TopRatedMovieSearchResponse>,
                response: Response<TopRatedMovieSearchResponse>
            ) {
                val topMovieSearchResponseData: TopRatedMovieSearchResponse?= response.body()
                if (topMovieSearchResponseData != null){
                    //Log.d("IMBD", topMovieSearchResponseData.toString())
                    data= topMovieSearchResponseData.results as MutableList<TopRatedMovie>
                    initRecyclerView()
                    getPosterPathMovie()
                }
            }
        }

        )


    }

    private fun initRecyclerView() {
        adapterMovies = MovieLinearHorizontalAdapter(data, this)
        with(binding.recyclerViewHome) {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterMovies

        }
    }

    private fun initData() {
        //val newData = getData()
        //data.clear()
        //data.addAll(newData)
        adapterMovies.notifyDataSetChanged()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: TopRatedMovie) {
        Toast.makeText(context, "MOVIE: "+movie.title, Toast.LENGTH_SHORT).show()
        activity?.let{
            val intent = Intent (it, DetailMovieActivity::class.java)
            intent.putExtra("TopRatedMovie",movie)
            intent.putExtra("Type","TopRatedMovie")
            it.startActivity(intent)
        }

    }

    }





