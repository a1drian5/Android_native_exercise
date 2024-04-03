package com.anushka.tmdbclient.presentation.topRateMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.usecase.GetTopRateMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateTopRateMoviesUsecase
import com.anushka.tmdbclient.presentation.movie.MovieViewModel

class TopRateMovieViewModelFactory(
    private val getTopRateMoviesUseCase: GetTopRateMoviesUseCase,
    private val updateTopRateMoviesUsecase: UpdateTopRateMoviesUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TopRateMovieViewModel(getTopRateMoviesUseCase,updateTopRateMoviesUsecase) as T
    }
}