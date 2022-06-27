package com.example.imbd.presentation.navigation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imbd.domain.Movie
import com.example.imbd.R

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