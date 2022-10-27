package com.megs.tmdbclient.domain.usecase

import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.getMovies()

}