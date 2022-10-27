package com.megs.tmdbclient.data.repository.movie.datasource

import com.megs.tmdbclient.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesInDB(movies: List<Movie>)
    suspend fun clearAll()
}