package com.megs.tmdbclient.data.repository.tvshow.datasource

import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow

interface ShowCacheDatasource {
    suspend fun getShowsFromCache() : List<TVShow>
    suspend fun saveShowsToCache(shows: List<TVShow>)
}