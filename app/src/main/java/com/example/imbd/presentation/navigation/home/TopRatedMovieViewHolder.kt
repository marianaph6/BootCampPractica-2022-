package com.example.imbd.presentation.navigation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imbd.databinding.ItemViewHolderTopRatedMovieBinding
import com.example.imbd.domain.model.TopRatedMovie

class TopRatedMovieViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewHolderTopRatedMovieBinding.bind(view)

    fun bind(model: TopRatedMovie, onClickListener: TopRatedMovieOnClickListener) {
        with(binding) {
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500/"+model.poster_path).into(imageViewLinearHorizontalPrincipal)
            textViewLinearHorizontalTitle.text = model.title
            textViewLinearHorizontalStar.text = model.vote_average.toString()
            btnDetailTopRatedMovie.setOnClickListener{onClickListener.onClick(model)}
        }
    }
}