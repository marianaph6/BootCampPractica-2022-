package com.example.recyclerviewkotlin.linearHorizontal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imbd.databinding.ItemViewHolderMovieHorizontalBinding
import com.example.imbd.domain.Movie

class MovieLinearHorizontalViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding = ItemViewHolderMovieHorizontalBinding.bind(view)

    fun bind(model: Movie, onClickListener: MovieOnClickListener) {
        with(binding) {
            Glide.with(itemView).load(model.url).into(imageViewLinearHorizontalPrincipal)
            textViewLinearHorizontalTitle.text = model.title
            textViewLinearHorizontalYear.text = model.year.toString()
            root.setOnClickListener {
                onClickListener.onClick(model)
            }
        }
    }
}