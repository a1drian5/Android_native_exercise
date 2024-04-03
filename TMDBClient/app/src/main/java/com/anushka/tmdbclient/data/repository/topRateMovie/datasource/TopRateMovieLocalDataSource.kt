package com.anushka.tmdbclient.data.repository.topRateMovie.datasource

import com.anushka.tmdbclient.data.model.movie.TopRateMovie

interface TopRateMovieLocalDataSource {
    suspend fun getTopRateMoviesFromDB():List<TopRateMovie>
    suspend fun saveTopRateMoviesToDB(topRateMovies:List<TopRateMovie>)
    suspend fun clearAll()
}