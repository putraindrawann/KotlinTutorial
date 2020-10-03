package com.example.kotlintutorial.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.MovieDetailActivity
import com.example.kotlintutorial.R
import com.example.kotlintutorial.listener.OnItemClickListener
import com.example.kotlintutorial.model.Movie

class MovieAdapter (val context: Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private val movies : MutableList<Movie> = mutableListOf()
    private var onSelectedListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.bindmodel(movies[position])

    }

    fun setMovie(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    fun getMovies(): MutableList<Movie> {
        return movies
    }

    inner class MovieViewHolder(item: View): RecyclerView.ViewHolder(item) {

        val txtTitle: TextView = item.findViewById(R.id.tv_title)
        val txtDescription: TextView = item.findViewById(R.id.tv_description)
        val cardviewMovie: CardView = item.findViewById(R.id.cv_movie)

        fun bindmodel(m: Movie) {
            txtTitle.text = m.getTitle()
            txtDescription.text = m.getDescription()

        }

        init {
            cardviewMovie.setOnClickListener{onSelectedListener?.onItemClick(it, layoutPosition)}
        }
    }

    fun setOnClickItemListener(onClickItemListener: OnItemClickListener) {
        this.onSelectedListener = onClickItemListener
    }
}