package com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl

import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieCacheDataSource

class TopRateMovieCacheDataSourceImpl : TopRateMovieCacheDataSource
    {
        private var topRateMovieList = ArrayList<TopRateMovie>()

        override suspend fun getTopRateMoviesFromCache(): List<TopRateMovie> {
            return topRateMovieList
        }

        override suspend fun saveTopRateMoviesToCache(topRateMovies: List<TopRateMovie>) {
            topRateMovieList.clear()
            topRateMovieList = ArrayList(topRateMovies)
        }
    }