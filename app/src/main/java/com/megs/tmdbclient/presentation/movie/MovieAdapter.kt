package com.megs.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.databinding.ListItemBinding

class MovieAdapter(private var movieList: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapterVH>() {
    private fun updateMovies(newMoviesList: List<Movie>) {
        movieList.clear()
        movieList.addAll(newMoviesList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return MovieAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapterVH, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

}

class MovieAdapterVH(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movieItem: Movie) {
//        binding.movie = movieItem
        binding.movieDescription.text = movieItem.overview
        binding.movieTitle.text = movieItem.title
        binding.movieReleaseDate.text = movieItem.releaseDate
        val posterURL = "https://image.tmdb.org/t/p/w500" + movieItem.posterPath
        Glide.with(binding.poster.context).load(posterURL).into(binding.poster)
    }

}