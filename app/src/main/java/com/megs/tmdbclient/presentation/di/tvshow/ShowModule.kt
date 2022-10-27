package com.megs.tmdbclient.presentation.di.tvshow

import com.megs.tmdbclient.domain.usecase.GetMoviesUseCase
import com.megs.tmdbclient.domain.usecase.GetShowsUseCase
import com.megs.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.megs.tmdbclient.domain.usecase.UpdateShowsUseCase
import com.megs.tmdbclient.presentation.movie.MovieViewModelFactory
import com.megs.tmdbclient.presentation.tvshows.ShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ShowModule {

    @ShowScope
    @Provides
    fun providesShowViewModelFactory(
        getShowsUseCase: GetShowsUseCase,
        updateShowUseCase: UpdateShowsUseCase
    ): ShowsViewModelFactory = ShowsViewModelFactory(getShowsUseCase, updateShowUseCase)
}