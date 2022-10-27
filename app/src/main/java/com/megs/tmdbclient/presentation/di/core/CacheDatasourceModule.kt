package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.megs.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.megs.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.megs.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.megs.tmdbclient.data.repository.tvshow.datasource.ShowCacheDatasource
import com.megs.tmdbclient.data.repository.tvshow.datasourceImpl.ShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDatasourceModule {

    @Singleton
    @Provides
    fun providesMovieCacheDatasource() : MovieCacheDatasource {
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesShowCacheDatasource() : ShowCacheDatasource {
        return ShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDatasource() : ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }
}