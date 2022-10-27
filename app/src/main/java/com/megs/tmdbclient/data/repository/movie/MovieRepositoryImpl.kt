package com.megs.tmdbclient.data.repository.movie

import android.util.Log
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.megs.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.megs.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.megs.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val remoteDatasource: MovieRemoteDatasource,
    private val localDatasource: MovieLocalDatasource,
    private val cacheDatasource: MovieCacheDatasource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        localDatasource.clearAll()
        localDatasource.saveMoviesInDB(newListOfMovies)
        cacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = remoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "getMoviesFromAPI: " + e.message)
        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = localDatasource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", "getMoviesFromDB: " + e.message)
        }

        if (movieList.isNotEmpty())
            return movieList
        else {
            movieList = getMoviesFromAPI()
            localDatasource.saveMoviesInDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = cacheDatasource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", "getMoviesFromCache: " + e.message)
        }
        if (movieList.isNotEmpty())
            return movieList
        else {
            movieList = getMoviesFromDB()
            cacheDatasource.saveMoviesToCache(movieList)
        }
        return movieList
    }


}