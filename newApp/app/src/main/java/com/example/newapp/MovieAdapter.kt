package com.example.newapp

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newapp.models.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter (
    private val movies: List<Movie>  ,private val context: Context
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie) {
            itemView.movie_title.text=movie.title
            itemView.movie_release_date.text="Release Date: " + movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra("id", movies[position].id)
            intent.putExtra("title", movies[position].title)
            intent.putExtra("img", movies[position].poster)
            intent.putExtra("desc", movies[position].description)
            intent.putExtra("release", movies[position].release)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = movies.size

}