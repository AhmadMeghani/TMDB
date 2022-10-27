package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.data.db.ArtistDAO
import com.megs.tmdbclient.data.db.MovieDAO
import com.megs.tmdbclient.data.db.TvShowDAO
import com.megs.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.megs.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.megs.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.megs.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.megs.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowLocalDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasourceImpl.ShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDatasourceModule {

    @Singleton
    @Provides
    fun providesMovieLocalDatasource(movieDAO: MovieDAO) : MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDAO)
    }

    @Singleton
    @Provides
    fun providesShowsLocalDatasource(showDAO: TvShowDAO) : ShowLocalDatasource {
        return ShowLocalDatasourceImpl(showDAO)
    }

    @Singleton
    @Provides
    fun providesArtistLocalDatasource(artistDAO: ArtistDAO) : ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDAO)
    }
}