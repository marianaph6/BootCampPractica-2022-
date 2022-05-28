package com.example.bootcamppractica2022.ui.search

import android.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcamppractica2022.Movie
import com.example.bootcamppractica2022.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {


    private lateinit var binding: FragmentSearchBinding

    private lateinit var adapterMovies: MovieAdapter

    private val data = mutableListOf<Movie>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRecyclerView()
        initData()
        return binding.root
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


}