package com.megs.tmdbclient.data.repository.artist.datasourceImpl

import com.megs.tmdbclient.data.db.ArtistDAO
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDAO: ArtistDAO) : ArtistLocalDatasource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDAO.getAllArtists()
    }

    override suspend fun saveArtistsInDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtist(artists)
        }

    }

    override suspend fun deleteAllArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }

    }
}