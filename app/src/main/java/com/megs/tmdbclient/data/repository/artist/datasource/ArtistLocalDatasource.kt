package com.megs.tmdbclient.data.repository.artist.datasource

import com.megs.tmdbclient.data.model.artist.Artist

interface ArtistLocalDatasource {
    suspend fun getArtistsFromDB() : List<Artist>

    suspend fun saveArtistsInDB(artists: List<Artist>)

    suspend fun deleteAllArtists()
}