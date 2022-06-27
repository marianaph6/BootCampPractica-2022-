package com.example.bootcamppractica2022.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcamppractica2022.commons.Movie
import com.example.bootcamppractica2022.R

class MovieAdapter(

    val data: List<Movie>
):RecyclerView.Adapter<MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  MovieViewHolder(
            layoutInflater.inflate(
                R.layout.item_view_holder_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bin(item)
    }

    override fun getItemCount(): Int= data.size
}