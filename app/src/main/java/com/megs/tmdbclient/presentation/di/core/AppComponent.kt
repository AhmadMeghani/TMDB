package com.megs.tmdbclient.presentation.di.core

import com.megs.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.megs.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.megs.tmdbclient.presentation.di.tvshow.ShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCasesModule::class,
        RepositoryModule::class,
        RemoteDatasourceModule::class,
        LocalDatasourceModule::class,
        CacheDatasourceModule::class
    ]
)
interface AppComponent {

    fun movieSubcomponent(): MoviesSubComponent.Factory
    fun artistSubcomponent(): ArtistSubComponent.Factory
    fun showSubcomponent(): ShowSubComponent.Factory
}