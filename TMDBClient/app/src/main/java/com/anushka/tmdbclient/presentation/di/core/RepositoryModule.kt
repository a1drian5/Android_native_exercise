package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.anushka.tmdbclient.data.repository.topRateMovie.TopRateMovieRepositoryImpl
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieCacheDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieLocalDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieRemoteDatasource
import com.anushka.tmdbclient.domain.repository.MovieRepository
import com.anushka.tmdbclient.domain.repository.TopRateMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTopRateMovieRepository(
        topRateMovieRemoteDatasource: TopRateMovieRemoteDatasource,
        topRateMovieLocalDataSource: TopRateMovieLocalDataSource,
        topRateMovieCacheDataSource: TopRateMovieCacheDataSource
    ): TopRateMovieRepository {

        return TopRateMovieRepositoryImpl(
            topRateMovieRemoteDatasource,
            topRateMovieLocalDataSource,
            topRateMovieCacheDataSource
        )
    }
}