package com.megs.tmdbclient.data.repository.tvshow.datasourceImpl

import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowCacheDatasource

class ShowCacheDatasourceImpl() : ShowCacheDatasource {
    private var showsList = ArrayList<TVShow>()

    override suspend fun getShowsFromCache(): List<TVShow> {
        return showsList
    }

    override suspend fun saveShowsToCache(shows: List<TVShow>) {
        showsList.clear()
        showsList = ArrayList(showsList)
    }
}