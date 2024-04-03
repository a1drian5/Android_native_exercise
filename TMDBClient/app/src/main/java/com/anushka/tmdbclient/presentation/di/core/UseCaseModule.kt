package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TopRateMovieRepository
import com.anushka.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTopRateMovieUseCase(topRateMovieRepository: TopRateMovieRepository):GetTopRateMoviesUseCase{
        return GetTopRateMoviesUseCase(topRateMovieRepository)
    }
    @Provides
    fun provideUpdateTopRateMovieUseCase(topRateMovieRepository: TopRateMovieRepository):UpdateTopRateMoviesUsecase{
        return UpdateTopRateMoviesUsecase(topRateMovieRepository)
    }
}