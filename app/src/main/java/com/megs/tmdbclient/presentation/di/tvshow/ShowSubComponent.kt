package com.megs.tmdbclient.presentation.di.tvshow

import com.megs.tmdbclient.presentation.artists.ArtistsActivity
import com.megs.tmdbclient.presentation.tvshows.ShowsActivity
import dagger.Subcomponent

@ShowScope
@Subcomponent(modules = [ShowModule::class])
interface ShowSubComponent {
    fun inject(showsActivity: ShowsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ShowSubComponent
    }
}