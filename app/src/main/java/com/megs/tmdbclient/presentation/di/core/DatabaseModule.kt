package com.megs.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.megs.tmdbclient.data.db.ArtistDAO
import com.megs.tmdbclient.data.db.MovieDAO
import com.megs.tmdbclient.data.db.TMDBDatabase
import com.megs.tmdbclient.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java, "TMDB_Database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase) : MovieDAO {
        return tmdbDatabase.movieDAO()
    }

    @Singleton
    @Provides
    fun provideShowsDAO(tmdbDatabase: TMDBDatabase) : TvShowDAO {
        return tmdbDatabase.showsDAO()
    }

    @Singleton
    @Provides
    fun provideArtistsDAO(tmdbDatabase: TMDBDatabase) : ArtistDAO {
        return tmdbDatabase.artistsDAO()
    }
}