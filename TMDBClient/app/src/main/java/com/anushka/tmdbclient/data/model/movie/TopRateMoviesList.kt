package com.anushka.tmdbclient.data.model.movie

import com.google.gson.annotations.SerializedName

data class TopRateMoviesList(
    @SerializedName("results")
    val topRateMovies: List<TopRateMovie>
)