package com.example.imbd.presentation.navigation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imbd.R
import com.example.imbd.domain.model.TopRatedMovie
import com.example.imbd.presentation.navigation.home.TopRatedMovieViewHolder

class MovieLinearHorizontalAdapter(
    val data: List<TopRatedMovie>,
    val onClickListener: TopRatedMovieOnClickListener

) : RecyclerView.Adapter<TopRatedMovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopRatedMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TopRatedMovieViewHolder(
            layoutInflater.inflate(
                R.layout.item_view_holder_top_rated_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = data.size

}
//Se le devuelve la info del objeto que seleccionó (Movie)
interface TopRatedMovieOnClickListener {
    fun onClick(movie: TopRatedMovie)
}