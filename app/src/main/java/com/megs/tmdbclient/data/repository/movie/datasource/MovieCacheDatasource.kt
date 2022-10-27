package com.megs.tmdbclient.data.repository.movie.datasource

import com.megs.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}