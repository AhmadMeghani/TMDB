package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.domain.repository.ArtistsRepository
import com.megs.tmdbclient.domain.repository.MovieRepository
import com.megs.tmdbclient.domain.repository.ShowsRepository
import com.megs.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Singleton
    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCase =
        GetMoviesUseCase(movieRepository)

    @Singleton
    @Provides
    fun provideUpdateMoviesUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepository)


    @Singleton
    @Provides
    fun provideGetShowsUseCase(showsRepository: ShowsRepository): GetShowsUseCase =
        GetShowsUseCase(showsRepository)

    @Singleton
    @Provides
    fun provideUpdateShowsUseCase(showsRepository: ShowsRepository): UpdateShowsUseCase =
        UpdateShowsUseCase(showsRepository)

    @Singleton
    @Provides
    fun provideGetArtistsUseCase(artistsRepository: ArtistsRepository): GetArtistsUseCase =
        GetArtistsUseCase(artistsRepository)

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistsRepository): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistsRepository)
}