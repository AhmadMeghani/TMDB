package com.megs.tmdbclient.data.repository.artist.datasource

import com.megs.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists() : Response<ArtistList>
}