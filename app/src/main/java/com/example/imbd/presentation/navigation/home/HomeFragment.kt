package com.example.imbd.presentation.navigation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imbd.databinding.FragmentHomeBinding
import com.example.imbd.domain.model.Movie
import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.network.TopRatedMovieService
import com.example.imbd.network.model.TopRatedMovieNetworkEntity
import com.example.imbd.network.model.TopRatedMovieNetworkMapper
import com.example.imbd.network.responses.TopRatedMovieSearchResponse
import com.example.recyclerviewkotlin.linearHorizontal.MovieLinearHorizontalAdapter
import com.example.recyclerviewkotlin.linearHorizontal.MovieOnClickListener
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment(), MovieOnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: MovieLinearHorizontalAdapter

    //private val data = mutableListOf<Movie>()

    private lateinit var svSearch: SearchView

    private var topRatedMovies= mutableListOf<TopRatedMovie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecyclerView()
        initData()

        val mapper = TopRatedMovieNetworkMapper()
        val topRatedMovie= TopRatedMovie()
        val networkEntity: TopRatedMovieNetworkEntity= mapper.mapToEntity(topRatedMovie)
        val m: TopRatedMovie= mapper.mapFromEntity(networkEntity)

        //val topRatedMovies: MutableState<List<TopRatedMovie>> = mutableStateOf(ArrayList())


        /*try {
    val topRatedMovie= service.get_top_rated_movies()
    Log.d( tag, "EXITO: "+topRatedMovie.top_rated_movies )

}
catch ( e : Exception )
{
    Log.d( tag, "Exception: " + e.message )
}*/
        //binding.searchViewMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener)
        return binding.root
    }

    private fun initListener(){


    }

    private fun searchTopRatedMovies(){
        val BASE_URL = "https://api.themoviedb.org/3/";
        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(TopRatedMovieService::class.java)

        CoroutineScope(IO).launch {

            service.get_top_rated_movies()
                .enqueue(object : Callback<TopRatedMovieSearchResponse> {
                    override fun onResponse(
                        call: Call<TopRatedMovieSearchResponse>,
                        response: Response<TopRatedMovieSearchResponse>
                    ) {
                        if (response.isSuccessful) {
                            val responseBody = response.body()

                            if (responseBody != null) {
                                topRatedMovies=responseBody.top_rated_movies.map {
                                    mapper.fromEntityList(listOf(it))
                                }
                                Log.d("Repository Succesfull", "Movies: $topRatedMovies")
                            } else {
                                Log.d("Repository", "Failed to get response")
                            }
                        }
                    }

                    override fun onFailure(call: Call<TopRatedMovieSearchResponse>, t: Throwable) {
                        Log.e("Repository", "onFailure", t)
                    }
                })


        }
    }

    private fun initRecyclerView() {
        adapterMovies = MovieLinearHorizontalAdapter(topRatedMovies, this)
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