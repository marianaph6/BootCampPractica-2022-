package com.example.imbd.presentation.navigation.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imbd.databinding.FragmentSearchBinding
import com.example.imbd.domain.model.ComicBookMovie
import com.example.imbd.network.ComicBookMovie.ComicBookMovieSearchResponse
import com.example.imbd.network.ComicBookMovie.ComicBookMovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment()  {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: ComicBookMovieAdapter

    private val data = mutableListOf<ComicBookMovie>()

    private lateinit var svSearch: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        getComicBookMovies()
        //binding.searchViewMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener)
        return binding.root
    }

    private fun getComicBookMovies(){

        val comicBookMovieSearchResponse= ComicBookMovieService.comicBookMovieInstance.getComicBookMovies()
        comicBookMovieSearchResponse.enqueue(object : Callback<ComicBookMovieSearchResponse> {
            override fun onFailure(call: Call<ComicBookMovieSearchResponse>, t: Throwable) {
                Log.d("IMBD", "Error cargando las peliculas", t)
            }

            override fun onResponse(
                call: Call<ComicBookMovieSearchResponse>,
                response: Response<ComicBookMovieSearchResponse>
            ) {
                val comicBookMovieSearchResponse: ComicBookMovieSearchResponse?= response.body()
                if (comicBookMovieSearchResponse != null){
                    Log.d("IMBD", comicBookMovieSearchResponse.toString())
                    initRecyclerView(comicBookMovieSearchResponse)
                }
            }
        }

        )


    }

    private fun initListener(){


    }

    private fun initRecyclerView(comicBookMovieSearchResponse: ComicBookMovieSearchResponse) {
        adapterMovies = ComicBookMovieAdapter(comicBookMovieSearchResponse.items)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity)
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


}