package com.anushka.tmdbclient.data.repository.topRateMovie.datasource

import com.anushka.tmdbclient.data.model.movie.TopRateMoviesList
import retrofit2.Response

interface TopRateMovieRemoteDatasource {
    suspend fun getTopRateMovies(): Response<TopRateMoviesList>
}