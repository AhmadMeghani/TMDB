package com.megs.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.megs.tmdbclient.domain.usecase.GetArtistsUseCase
import com.megs.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        emit(getArtistsUseCase.execute())
    }

    fun updateArtists() = liveData {
        emit(updateArtistsUseCase.execute())
    }
}