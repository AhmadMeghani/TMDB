package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.data.api.TMDBService
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.megs.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.megs.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.megs.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.megs.tmdbclient.data.repository.movie.datasourceImpl.ShowRemoteDatasourceImpl
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDatasourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesMovieRemoteDatasource(tmdbService: TMDBService) : MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesShowsRemoteDatasource(tmdbService: TMDBService) : ShowRemoteDatasource {
        return ShowRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDatasource(tmdbService: TMDBService) : ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService, apiKey)
    }
}