package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.domain.repository.TopRateMovieRepository

class GetTopRateMoviesUseCase(private val topRateMovieRepository: TopRateMovieRepository) {

    suspend fun execute():List<TopRateMovie>? = topRateMovieRepository.getTopRateMovies()

}