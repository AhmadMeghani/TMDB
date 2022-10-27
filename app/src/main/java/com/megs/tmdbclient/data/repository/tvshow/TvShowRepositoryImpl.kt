package com.megs.tmdbclient.data.repository.tvshow

import android.util.Log
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowCacheDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowLocalDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowRemoteDatasource
import com.megs.tmdbclient.domain.repository.MovieRepository
import com.megs.tmdbclient.domain.repository.ShowsRepository

class TvShowRepositoryImpl(
    private val remoteDatasource: ShowRemoteDatasource,
    private val localDatasource: ShowLocalDatasource,
    private val cacheDatasource: ShowCacheDatasource
) : ShowsRepository {
    override suspend fun getShows(): List<TVShow>? {
        return getShowsFromCache()
    }

    override suspend fun updateShows(): List<TVShow>? {
        val newListOfShows = getShowsFromAPI()
        localDatasource.clearAllShows()
        localDatasource.saveShowsInDB(newListOfShows)
        cacheDatasource.saveShowsToCache(newListOfShows)
        return newListOfShows
    }

    suspend fun getShowsFromAPI(): List<TVShow> {
        lateinit var showsList: List<TVShow>

        try {
            val response = remoteDatasource.getShows()
            val body = response.body()
            if (body != null) {
                showsList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "getShowsFromAPI: " + e.message)
        }

        return showsList
    }

    suspend fun getShowsFromDB(): List<TVShow> {
        lateinit var showsList: List<TVShow>

        try {
            showsList = localDatasource.getShowsFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", "getShowsFromDB: " + e.message)
        }

        if (showsList.isNotEmpty())
            return showsList
        else {
            showsList = getShowsFromAPI()
            localDatasource.saveShowsInDB(showsList)
        }
        return showsList
    }

    suspend fun getShowsFromCache(): List<TVShow> {
        lateinit var showsList: List<TVShow>

        try {
            showsList = cacheDatasource.getShowsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", "getMoviesFromCache: " + e.message)
        }
        if (showsList.isNotEmpty())
            return showsList
        else {
            showsList = getShowsFromDB()
            cacheDatasource.saveShowsToCache(showsList)
        }
        return showsList
    }


}