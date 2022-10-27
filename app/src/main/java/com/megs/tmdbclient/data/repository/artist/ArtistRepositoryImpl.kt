package com.megs.tmdbclient.data.repository.artist

import android.util.Log
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.megs.tmdbclient.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(
    private val remoteDatasource: ArtistRemoteDatasource,
    private val localDatasource: ArtistLocalDatasource,
    private val cacheDatasource: ArtistCacheDatasource
) : ArtistsRepository{
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val list = getArtistsFromAPI();
        localDatasource.deleteAllArtists()
        localDatasource.saveArtistsInDB(list)
        cacheDatasource.saveArtistsToCache(list)
        return list
    }

    suspend fun getArtistsFromAPI() : List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            val response = remoteDatasource.getArtists();
            val body = response.body()

            if(body != null) {
                artistsList = body.artists
            }
        } catch (e: Exception) {
            Log.i("MYTAG", "getArtistsFromAPI: " + e.message)
        }

        return artistsList

    }

    suspend fun getArtistsFromDB() : List<Artist> {
        lateinit var artistsList : List<Artist>

        try {
            artistsList = localDatasource.getArtistsFromDB()
            if (artistsList.isNotEmpty()) {
                return artistsList
            } else {
                artistsList = getArtistsFromAPI()
                localDatasource.saveArtistsInDB(artistsList)
            }
        } catch (e : Exception) {
            Log.i("MYTAG", "getArtistsFromDB: " + e.message)
        }

        return artistsList
    }

    suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistsList: List<Artist>

        try {
            artistsList = cacheDatasource.getArtistsFromCache()
            if (artistsList.isNotEmpty()) {
                return artistsList
            } else {
                artistsList = getArtistsFromDB()
                cacheDatasource.saveArtistsToCache(artistsList)
            }
        } catch (e : Exception) {
            Log.i("MYTAG", "getArtistsFromDB: " + e.message)
        }

        return artistsList

    }

}