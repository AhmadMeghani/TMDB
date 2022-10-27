package com.megs.tmdbclient.data.repository.movie.datasourceImpl

import com.megs.tmdbclient.data.db.MovieDAO
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDAO: MovieDAO) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getAllMovies()
    }

    override suspend fun saveMoviesInDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}