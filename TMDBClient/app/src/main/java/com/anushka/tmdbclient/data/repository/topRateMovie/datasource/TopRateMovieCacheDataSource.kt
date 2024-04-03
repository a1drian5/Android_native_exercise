package com.anushka.tmdbclient.data.repository.topRateMovie.datasource

import com.anushka.tmdbclient.data.model.movie.TopRateMovie

interface TopRateMovieCacheDataSource {
    suspend fun getTopRateMoviesFromCache():List<TopRateMovie>
    suspend fun saveTopRateMoviesToCache(topRateMovies:List<TopRateMovie>)
}