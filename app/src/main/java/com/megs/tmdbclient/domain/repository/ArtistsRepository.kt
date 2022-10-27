package com.megs.tmdbclient.domain.repository

import androidx.lifecycle.LiveData
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.model.movie.Movie

interface ArtistsRepository {

    suspend fun getArtists() : List<Artist>?

    suspend fun updateArtists() : List<Artist>?
}