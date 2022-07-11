package com.example.imbd.presentation.navigation.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imbd.databinding.FragmentSearchBinding
import com.example.imbd.domain.model.ComicBookMovie
import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.network.ComicBookMovie.ComicBookMovieSearchResponse
import com.example.imbd.network.ComicBookMovie.ComicBookMovieService
import com.example.imbd.presentation.navigation.detail.DetailMovieActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment(), ComicBookMovieAdapter.ComicBookMovieOnClickListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var data : ArrayList<ComicBookMovie> = arrayListOf()
    private var matchedBookMovie: ArrayList<ComicBookMovie> = arrayListOf()
    private var adapterMovies: ComicBookMovieAdapter = ComicBookMovieAdapter(data,this)

    private lateinit var svSearch: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        getComicBookMovies()
        performSearch()
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
                    data= comicBookMovieSearchResponse.items as ArrayList<ComicBookMovie>
                    initRecyclerView()
                    adapterMovies.notifyDataSetChanged()
                }
            }
        }

        )


    }

    private fun performSearch() {
        binding.searchViewMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {
        matchedBookMovie = arrayListOf()

        text?.let {
            data.forEach { movie ->
                if (movie.title.toString().contains(text, true) ||
                    movie.original_title.toString().contains(text, true)
                ) {
                    matchedBookMovie.add(movie)
                }
            }
            updateRecyclerView()
            if (matchedBookMovie.isEmpty()) {
                Toast.makeText(context, "No match found!", Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        binding.recyclerView.apply {
            adapterMovies.data = matchedBookMovie
            adapterMovies.notifyDataSetChanged()
        }
    }





    private fun initListener(){


    }

    private fun initRecyclerView() {
        adapterMovies = ComicBookMovieAdapter(data,this)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = adapterMovies

        }
        binding.searchViewMovie.isSubmitButtonEnabled = true
    }

    private fun initData() {
        //val newData = getData()
        //data.clear()
        //data.addAll(newData)
        adapterMovies.notifyDataSetChanged()
    }

    override fun onClick(movie: ComicBookMovie) {
        Toast.makeText(context, "MOVIE: "+movie.title, Toast.LENGTH_SHORT).show()
        activity?.let{
            val intent = Intent (it, DetailMovieActivity::class.java)
            intent.putExtra("ComicBookMovie",movie)
            intent.putExtra("Type","ComicBookMovie")
            it.startActivity(intent)
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}