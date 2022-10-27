package com.megs.tmdbclient.data.repository.artist.datasource

import com.megs.tmdbclient.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}