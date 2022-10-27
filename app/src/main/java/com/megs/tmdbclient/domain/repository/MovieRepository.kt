package com.megs.tmdbclient.domain.repository

import androidx.lifecycle.LiveData
import com.megs.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}