package com.megs.tmdbclient.presentation.di.movie

import com.megs.tmdbclient.presentation.artists.ArtistsActivity
import com.megs.tmdbclient.presentation.movie.MoviesActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MoviesSubComponent {
    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MoviesSubComponent
    }
}