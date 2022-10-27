package com.megs.tmdbclient.presentation

import android.app.Application
import com.megs.tmdbclient.BuildConfig
import com.megs.tmdbclient.presentation.di.Injector
import com.megs.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.megs.tmdbclient.presentation.di.core.*
import com.megs.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.megs.tmdbclient.presentation.di.tvshow.ShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDatasourceModule(RemoteDatasourceModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMoviesSubcomponent(): MoviesSubComponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createShowsSubcomponent(): ShowSubComponent {
        return appComponent.showSubcomponent().create()
    }

    override fun createArtistsSubcomponent(): ArtistSubComponent {
        return appComponent.artistSubcomponent().create()
    }
}