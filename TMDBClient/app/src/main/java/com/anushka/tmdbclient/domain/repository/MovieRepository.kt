package com.anushka.tmdbclient.domain.repository

import com.anushka.tmdbclient.data.model.movie.Movie

//  Ayuda a abstraer la fuente de datos subyacente y proporciona un punto de entrada único para la lógica de negocio de la aplicación
interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}