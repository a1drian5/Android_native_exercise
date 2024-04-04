package com.anushka.tmdbclient.data.api

import com.anushka.tmdbclient.data.model.movie.MovieList
import com.anushka.tmdbclient.data.model.movie.TopRateMoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// Se encarga de obtener el endpoint de la app
interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String // Parámetro para el idioma
    ): Response<MovieList>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String // Parámetro para el idioma
    ): Response<TopRateMoviesList>
}