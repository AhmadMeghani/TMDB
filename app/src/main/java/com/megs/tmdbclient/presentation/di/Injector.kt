package com.megs.tmdbclient.presentation.di

import com.megs.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.megs.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.megs.tmdbclient.presentation.di.tvshow.ShowSubComponent

interface Injector {
    fun createMoviesSubcomponent(): MoviesSubComponent
    fun createShowsSubcomponent(): ShowSubComponent
    fun createArtistsSubcomponent(): ArtistSubComponent
}