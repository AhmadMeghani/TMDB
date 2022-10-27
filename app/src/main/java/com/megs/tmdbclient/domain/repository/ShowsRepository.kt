package com.megs.tmdbclient.domain.repository

import androidx.lifecycle.LiveData
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow

interface ShowsRepository {

    suspend fun getShows() : List<TVShow>?

    suspend fun updateShows() : List<TVShow>?
}