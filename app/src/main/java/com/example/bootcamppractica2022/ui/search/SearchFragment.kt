package com.example.bootcamppractica2022.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcamppractica2022.commons.Movie
import com.example.bootcamppractica2022.databinding.FragmentHomeBinding
import com.example.bootcamppractica2022.databinding.FragmentSearchBinding


class SearchFragment : Fragment()  {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterMovies: MovieAdapter

    private val data = mutableListOf<Movie>()

    private lateinit var svSearch: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRecyclerView()
        initData()
        //binding.searchViewMovie.setOnQueryTextListener(object: SearchView.OnQueryTextListener)
        return binding.root
    }

    private fun initListener(){


    }

    private fun initRecyclerView() {
        adapterMovies = MovieAdapter(data)
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = adapterMovies

        }
    }

    private fun initData() {
        val newData = getData()
        data.clear()
        data.addAll(newData)
        adapterMovies.notifyDataSetChanged()
    }


    private fun getData(): List<Movie>{
        val list = listOf("Actor1", "Actor2", "Ator3")
        return  listOf(

            Movie(
                url = "https://es.web.img2.acsta.net/pictures/16/10/26/16/34/380275.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 2020,
            ),
            Movie(
                url = "https://i.pinimg.com/564x/05/c7/5a/05c75a7b6c4d938dfcc5e3015188b3cc.jpg",
                title = "La sirenita",
                //rating = 4.3F,
                actors = list,
                year = 1998,
            ),
            Movie(
                url = "https://es.web.img2.acsta.net/pictures/16/10/26/16/34/380275.jpg",
                title = "Sully",
                //rating = 5.0F,
                actors = list,
                year = 202,
            ),
        )

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}