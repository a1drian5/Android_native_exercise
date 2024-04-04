package com.anushka.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.movie.TopRateMovie

//  Proporciona un punto de acceso principal para interactuar con la base de datos SQLite
@Database(entities = [Movie::class,TopRateMovie::class],
version = 1,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun topRateMovieDao(): TopRateMovieDao
}