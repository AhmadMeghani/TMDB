package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.megs.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.megs.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.megs.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.megs.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.megs.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowCacheDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowLocalDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowRemoteDatasource
import com.megs.tmdbclient.domain.repository.ArtistsRepository
import com.megs.tmdbclient.domain.repository.MovieRepository
import com.megs.tmdbclient.domain.repository.ShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        moviesRemoteDatasource: MovieRemoteDatasource,
        moviesLocalDatasource: MovieLocalDatasource,
        moviesCacheDatasource: MovieCacheDatasource
    ): MovieRepository {

        return MovieRepositoryImpl(
            moviesRemoteDatasource,
            moviesLocalDatasource,
            moviesCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideShowsRepository(
        showsRemoteDatasource: ShowRemoteDatasource,
        showsLocalDatasource: ShowLocalDatasource,
        showsCacheDatasource: ShowCacheDatasource
    ): ShowsRepository {

        return TvShowRepositoryImpl(
            showsRemoteDatasource,
            showsLocalDatasource,
            showsCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistsRemoteDatasource: ArtistRemoteDatasource,
        artistsLocalDatasource: ArtistLocalDatasource,
        artistsCacheDatasource: ArtistCacheDatasource
    ): ArtistsRepository {

        return ArtistRepositoryImpl(
            artistsRemoteDatasource,
            artistsLocalDatasource,
            artistsCacheDatasource
        )
    }
}