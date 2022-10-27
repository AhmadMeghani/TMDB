package com.megs.tmdbclient.data.repository.artist.datasourceImpl

import com.megs.tmdbclient.data.db.ArtistDAO
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl() : ArtistCacheDatasource {
    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}