package com.anushka.tmdbclient.presentation.topRateMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.usecase.GetTopRateMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateTopRateMoviesUsecase

class TopRateMovieViewModel(
    private val getTopRateMoviesUseCase: GetTopRateMoviesUseCase,
    private val updateTopRateMoviesUsecase: UpdateTopRateMoviesUsecase
) : ViewModel() {

    // En este caso utilizamos liveData para emitir los datos
    fun getTopRateMovies() = liveData {
        val topRateMovieList = getTopRateMoviesUseCase.execute()
        emit(topRateMovieList)
    }

    fun updateTopRateMovies() = liveData {
        val topRateMovieList = updateTopRateMoviesUsecase.execute()
        emit(topRateMovieList)
    }
}