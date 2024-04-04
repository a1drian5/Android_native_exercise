package com.anushka.tmdbclient.data.model.movie


import com.anushka.tmdbclient.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

// lista de películas (movies) obtenidas de una respuesta
data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)