package com.megs.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.megs.tmdbclient.data.model.movie.Movie
import com.megs.tmdbclient.data.model.tvshow.TVShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(showsList: List<TVShow>)

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllShows()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getAllShows(): List<TVShow>
}