package com.megs.tmdbclient.presentation.di.core

import android.content.Context
import com.megs.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.megs.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.megs.tmdbclient.presentation.di.tvshow.ShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MoviesSubComponent::class, ArtistSubComponent::class, ShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = context.applicationContext
}