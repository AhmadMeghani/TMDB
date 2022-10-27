package com.megs.tmdbclient.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.databinding.ListItemBinding

class ShowAdapter(private var TVShowList: ArrayList<TVShow>): RecyclerView.Adapter<TVShowAdapterVH>() {
    private fun updateTVShows(newTVShowsList: List<TVShow>) {
        TVShowList.clear()
        TVShowList.addAll(newTVShowsList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowAdapterVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return TVShowAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: TVShowAdapterVH, position: Int) {
        holder.bind(TVShowList[position])
    }

    override fun getItemCount(): Int = TVShowList.size

}

class TVShowAdapterVH(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(TVShowItem: TVShow) {
        binding.movieReleaseDate.text = TVShowItem.firstAirDate
        binding.movieTitle.text = TVShowItem.name
        binding.movieDescription.text = TVShowItem.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + TVShowItem.posterPath
        Glide.with(binding.poster.context).load(posterURL).into(binding.poster)
    }

}