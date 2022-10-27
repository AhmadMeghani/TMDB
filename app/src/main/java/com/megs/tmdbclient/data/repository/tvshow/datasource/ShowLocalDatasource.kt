package com.megs.tmdbclient.data.repository.tvshow.datasource

import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow

interface ShowLocalDatasource {
    suspend fun getShowsFromDB() : List<TVShow>
    suspend fun saveShowsInDB(shows: List<TVShow>)
    suspend fun clearAllShows()
}