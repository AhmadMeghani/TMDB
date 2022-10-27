package com.megs.tmdbclient.domain.usecase

import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.domain.repository.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {

    suspend fun execute() : List<Artist>? = artistsRepository.getArtists()

}