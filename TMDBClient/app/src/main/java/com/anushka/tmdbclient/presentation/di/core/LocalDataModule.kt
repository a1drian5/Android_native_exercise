package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.db.MovieDao
import com.anushka.tmdbclient.data.db.TopRateMovieDao
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieLocalDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl.TopRateMovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTopRateMovieLocalDataSource(topRateMovieDao: TopRateMovieDao): TopRateMovieLocalDataSource {
        return TopRateMovieLocalDataSourceImpl(topRateMovieDao)
    }
}