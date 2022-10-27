package com.megs.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.megs.tmdbclient.domain.usecase.GetMoviesUseCase
import com.megs.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        emit(getMoviesUseCase.execute())
    }

    fun updateMovies() = liveData {
        emit(updateMoviesUseCase.execute())
    }
}