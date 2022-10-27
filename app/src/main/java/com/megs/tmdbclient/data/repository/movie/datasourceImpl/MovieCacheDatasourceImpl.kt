package com.megs.tmdbclient.data.repository.movie.datasourceImpl

import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowCacheDatasource

class MovieCacheDatasourceImpl() : MovieCacheDatasource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}