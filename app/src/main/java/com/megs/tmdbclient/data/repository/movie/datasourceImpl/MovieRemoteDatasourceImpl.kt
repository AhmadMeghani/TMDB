package com.megs.tmdbclient.data.repository.movie.datasourceImpl

import com.megs.tmdbclient.data.api.TMDBService
import com.megs.tmdbclient.data.model.movie.MovieList
import com.megs.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}