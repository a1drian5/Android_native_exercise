package com.anushka.tmdbclient.presentation.di.core

import com.anushka.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieCacheDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl.TopRateMovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTopRateMovieCacheDataSource(): TopRateMovieCacheDataSource {
        return TopRateMovieCacheDataSourceImpl()
    }
}