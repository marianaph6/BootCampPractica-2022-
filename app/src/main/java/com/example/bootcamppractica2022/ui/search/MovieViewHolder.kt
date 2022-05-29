package com.example.bootcamppractica2022.ui.search

import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bootcamppractica2022.Movie
import com.example.bootcamppractica2022.databinding.ItemViewHolderMovieBinding

class MovieViewHolder (

    view: View

): RecyclerView.ViewHolder(view){

    private val binding= ItemViewHolderMovieBinding.bind(view)

    fun bin (model: Movie){
        with(binding){
            Glide.with(itemView).load(model.url).into((imageViewPrincipal))
            textViewTitle.text=model.title
            textViewYear.text=model.year.toString()
            textViewActors.text = java.lang.String.join(",", model.actors)
            //ratingBar.numStars=model.rating.roundToInt()
        }

    }
}


