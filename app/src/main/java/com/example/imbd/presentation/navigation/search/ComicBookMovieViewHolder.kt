package com.example.imbd.presentation.navigation.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imbd.databinding.ItemViewHolderComicBookMovieBinding
import com.example.imbd.domain.model.ComicBookMovie

class ComicBookMovieViewHolder (

    view: View

): RecyclerView.ViewHolder(view){

    private val binding= ItemViewHolderComicBookMovieBinding.bind(view)

    fun bind (model: ComicBookMovie, onClickListener: ComicBookMovieAdapter.ComicBookMovieOnClickListener){
        with(binding){
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500/"+model.poster_path).into((imageViewComicBookMoviePoster))
            textViewComicBookMovieTitle.text=model.title
            textViewComicBookMovieYear.text=model.release_date.toString()
            textViewComicBookMovieType.text=model.media_type
            root.setOnClickListener {
                onClickListener.onClick(model)
            }
            //ratingBar.numStars=model.rating.roundToInt()
        }

    }
}


