package com.megs.tmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.megs.tmdbclient.domain.usecase.GetShowsUseCase
import com.megs.tmdbclient.domain.usecase.UpdateShowsUseCase

class ShowsViewModelFactory(
    private val getShowsUseCase: GetShowsUseCase,
    private val updateShowsUseCase: UpdateShowsUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowsViewModel(getShowsUseCase, updateShowsUseCase) as T
    }
}