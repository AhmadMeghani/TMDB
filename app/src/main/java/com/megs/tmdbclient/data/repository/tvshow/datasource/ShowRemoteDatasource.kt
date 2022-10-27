package com.megs.tmdbclient.data.repository.tvshow.datasource

import com.megs.tmdbclient.data.model.movie.MovieList
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface ShowRemoteDatasource {
    suspend fun getShows() : Response<TvShowList>
}