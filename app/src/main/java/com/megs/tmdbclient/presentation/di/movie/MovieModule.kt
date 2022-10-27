package com.megs.tmdbclient.presentation.di.movie

import com.megs.tmdbclient.domain.usecase.GetMoviesUseCase
import com.megs.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.megs.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory = MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
}