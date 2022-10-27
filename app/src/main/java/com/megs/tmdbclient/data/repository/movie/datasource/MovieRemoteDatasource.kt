package com.megs.tmdbclient.data.repository.movie.datasource

import com.megs.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies() : Response<MovieList>
}