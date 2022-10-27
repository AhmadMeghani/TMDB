package com.megs.tmdbclient.presentation.di.artist

import com.megs.tmdbclient.domain.usecase.GetArtistsUseCase
import com.megs.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.megs.tmdbclient.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory = ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
}