package com.megs.tmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.megs.tmdbclient.domain.usecase.GetShowsUseCase
import com.megs.tmdbclient.domain.usecase.UpdateShowsUseCase

class ShowsViewModel(
    private val getShowsUseCase: GetShowsUseCase,
    private val updateShowsUseCase: UpdateShowsUseCase
) : ViewModel() {

    fun getShows() = liveData {
        emit(getShowsUseCase.execute())
    }

    fun updateShows() = liveData {
        emit(updateShowsUseCase.execute())
    }
}