package com.megs.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.databinding.ListItemBinding

class ArtistAdapter(private var ArtistList: ArrayList<Artist>): RecyclerView.Adapter<ArtistAdapterVH>() {
    private fun updateArtists(newArtistsList: List<Artist>) {
        ArtistList.clear()
        ArtistList.addAll(newArtistsList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapterVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ArtistAdapterVH(binding)
    }

    override fun onBindViewHolder(holder: ArtistAdapterVH, position: Int) {
        holder.bind(ArtistList[position])
    }

    override fun getItemCount(): Int = ArtistList.size

}

class ArtistAdapterVH(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ArtistItem: Artist) {
        binding.movieReleaseDate.visibility = View.GONE
        binding.movieTitle.text = ArtistItem.name
        binding.movieDescription.visibility = View.GONE
        val posterURL = "https://image.tmdb.org/t/p/w500" + ArtistItem.profilePath
        Glide.with(binding.poster.context).load(posterURL).into(binding.poster)
    }

}