package com.example.recyclerviewkotlin.linearHorizontal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imbd.databinding.ItemViewHolderMovieHorizontalBinding
import com.example.imbd.domain.model.TopRatedMovie

class MovieLinearHorizontalViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewHolderMovieHorizontalBinding.bind(view)

    fun bind(model: TopRatedMovie, onClickListener: MovieOnClickListener) {
        with(binding) {
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500/"+model.poster_path).into(imageViewLinearHorizontalPrincipal)
            textViewLinearHorizontalTitle.text = model.title
            textViewLinearHorizontalStar.text = model.vote_average.toString()
            root.setOnClickListener {
                onClickListener.onClick(model)
            }
        }
    }
}