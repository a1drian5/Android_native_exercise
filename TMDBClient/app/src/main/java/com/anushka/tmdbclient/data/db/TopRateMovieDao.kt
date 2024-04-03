package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.movie.TopRateMovie

@Dao
interface TopRateMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopRateMovies(topRateMovies: List<TopRateMovie>)

    @Query("DELETE FROM top_rate_movies")
    suspend fun deleteAllTopRateMovies()

    @Query("SELECT * FROM top_rate_movies")
    suspend fun getTopRateMovies(): List<TopRateMovie>
}