package com.example.imbd.presentation.navigation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imbd.R
import com.example.imbd.domain.model.ComicBookMovie

class ComicBookMovieAdapter(

    var data: ArrayList<ComicBookMovie>
):RecyclerView.Adapter<ComicBookMovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicBookMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  ComicBookMovieViewHolder(
            layoutInflater.inflate(
                R.layout.item_view_holder_comic_book_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComicBookMovieViewHolder, position: Int) {
        val item = data[position]
        holder.bin(item)
    }


    override fun getItemCount(): Int= data.size
}