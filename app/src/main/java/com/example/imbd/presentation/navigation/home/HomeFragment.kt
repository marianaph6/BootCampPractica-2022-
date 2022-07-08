package com.example.imbd.presentation.navigation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imbd.databinding.FragmentHomeBinding
import com.example.imbd.domain.model.Movie
import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.network.TopRatedMovieService
import com.example.imbd.network.TopRatedMovie.TopRatedMovieSearchResponse
import com.example.recyclerviewkotlin.linearHorizontal.MovieLinearHorizontalAdapter
import com.example.recyclerviewkotlin.linearHorizontal.MovieOnClickListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), MovieOnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: MovieLinearHorizontalAdapter


    private var topRatedMovies= mutableListOf<TopRatedMovie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        getTopRatedMovies()

        return binding.root
    }

    private fun initListener(){


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
                val topMovieSearchResponse: TopRatedMovieSearchResponse?= response.body()
                if (topMovieSearchResponse != null){
                    Log.d("IMBD", topMovieSearchResponse.toString())
                    initRecyclerView(topMovieSearchResponse)
                }
            }
        }

        )


    }

    private fun initRecyclerView(topRatedMovieSearchResponse: TopRatedMovieSearchResponse) {
        adapterMovies = MovieLinearHorizontalAdapter(topRatedMovieSearchResponse.results, this)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterMovies

        }
    }

    private fun initData() {
        val newData = getData()
        //data.clear()
        //data.addAll(newData)
        adapterMovies.notifyDataSetChanged()
    }


    private fun getData(): List<Movie> {
        val list = listOf("Actor1", "Actor2", "Ator3")
        return listOf(
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
            Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),Movie(
                url = "https://www.aceprensa.com/wp-content/uploads/2016/11/363676-0.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020
            ),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: TopRatedMovie) {
        TODO("Not yet implemented")
    }
}