package com.megs.tmdbclient.domain.usecase

import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.domain.repository.ShowsRepository

class UpdateShowsUseCase(private val showsRepository: ShowsRepository) {

    suspend fun execute(): List<TVShow>? = showsRepository.updateShows()
}