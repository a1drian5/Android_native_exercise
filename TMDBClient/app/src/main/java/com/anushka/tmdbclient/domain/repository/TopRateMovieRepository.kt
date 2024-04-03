package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.movie.TopRateMovie

interface TopRateMovieRepository {

    suspend fun getTopRateMovies():List<TopRateMovie>?
    suspend fun updateTopRateMovies():List<TopRateMovie>?
}