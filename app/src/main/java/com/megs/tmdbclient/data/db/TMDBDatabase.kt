package com.megs.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.megs.tmdbclient.data.model.artist.Artist
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDAO(): MovieDAO

    abstract fun showsDAO(): TvShowDAO

    abstract fun artistsDAO(): ArtistDAO
}