package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.domain.repository.TopRateMovieRepository

class UpdateTopRateMoviesUsecase(private val topRateMovieRepository: TopRateMovieRepository) {
    suspend fun execute():List<TopRateMovie>? = topRateMovieRepository.updateTopRateMovies()

}