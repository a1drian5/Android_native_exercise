package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.BuildConfig
import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieRemoteDatasource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl.TopRateMovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTopRateMovieRemoteDataSource(tmdbService: TMDBService): TopRateMovieRemoteDatasource {
        return TopRateMovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }
}