package com.megs.tmdbclient.data.repository.tvshow.datasourceImpl

import com.megs.tmdbclient.data.db.TvShowDAO
import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowLocalDatasourceImpl(private val showDAO: TvShowDAO) : ShowLocalDatasource {
    override suspend fun getShowsFromDB(): List<TVShow> {
        return showDAO.getAllShows()
    }

    override suspend fun saveShowsInDB(shows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            showDAO.saveTVShows(shows)
        }

    }

    override suspend fun clearAllShows() {
        CoroutineScope(Dispatchers.IO).launch {
            showDAO.deleteAllShows()
        }
    }
}