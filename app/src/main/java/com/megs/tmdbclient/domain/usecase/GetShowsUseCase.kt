package com.megs.tmdbclient.domain.usecase

import com.megs.tmdbclient.data.model.tvshow.TVShow
import com.megs.tmdbclient.domain.repository.ShowsRepository

class GetShowsUseCase(private val showsRepository: ShowsRepository) {

    suspend fun execute() : List<TVShow>? = showsRepository.getShows()

}