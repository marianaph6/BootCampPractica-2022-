package com.example.recyclerviewkotlin.linearHorizontal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imbd.R
import com.example.imbd.domain.Movie

class MovieLinearHorizontalAdapter(
    val data: List<Movie>,
    //Clase que instancia la interfaz
    val onClickListener: MovieOnClickListener
) : RecyclerView.Adapter<MovieLinearHorizontalViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieLinearHorizontalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieLinearHorizontalViewHolder(
            layoutInflater.inflate(
                R.layout.item_view_holder_movie_horizontal,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieLinearHorizontalViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = data.size

}
//Se le devuelve la info del objeto que seleccionó (Movie)
interface MovieOnClickListener {
    fun onClick(movie: Movie)
}