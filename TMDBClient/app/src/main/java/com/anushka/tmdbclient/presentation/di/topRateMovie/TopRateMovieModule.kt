package com.anushka.tmdbclient.presentation.di.topRateMovie

import com.anushka.tmdbclient.domain.usecase.GetTopRateMoviesUseCase
import com.anushka.tmdbclient.domain.usecase.UpdateTopRateMoviesUsecase
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TopRateMovieModule {
    @ActivityScoped
    @Provides
    fun provideTopRateMovieViewModelFactory(
        getTopRateMoviesUseCase: GetTopRateMoviesUseCase,
        updateTopRateMoviesUsecase: UpdateTopRateMoviesUsecase
    ): TopRateMovieViewModelFactory {
        return TopRateMovieViewModelFactory(
            getTopRateMoviesUseCase,
            updateTopRateMoviesUsecase
        )
    }
}