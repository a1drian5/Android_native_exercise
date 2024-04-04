package com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl

import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.model.movie.TopRateMoviesList
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieRemoteDatasource
import retrofit2.Response

class TopRateMovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String,
    private var language: String
) : TopRateMovieRemoteDatasource {
    override suspend fun getTopRateMovies(): Response<TopRateMoviesList> = tmdbService.getTopRatedMovies(apiKey, language)

}