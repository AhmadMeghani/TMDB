package com.megs.tmdbclient.data.repository.movie.datasourceImpl

import com.megs.tmdbclient.data.api.TMDBService
import com.megs.tmdbclient.data.model.movie.MovieList
import com.megs.tmdbclient.data.model.tvshow.TvShowList
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowRemoteDatasource
import retrofit2.Response

class ShowRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ShowRemoteDatasource {

    override suspend fun getShows(): Response<TvShowList> = tmdbService.getPopularTVShows(apiKey)

}