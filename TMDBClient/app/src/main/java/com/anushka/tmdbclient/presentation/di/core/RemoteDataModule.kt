package com.anushka.tmdbclient.presentation.di.core

import android.content.Context
import com.anushka.tmdbclient.BuildConfig
import com.anushka.tmdbclient.data.api.TMDBService
import com.anushka.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.anushka.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieRemoteDatasource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl.TopRateMovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService,@Named("language") language: String): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY, language
        )
    }

    @Singleton
    @Provides
    fun provideTopRateMovieRemoteDataSource(tmdbService: TMDBService,@Named("language") language: String): TopRateMovieRemoteDatasource {
        return TopRateMovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY, language
        )
    }

    @Provides
    @Named("language")
    fun provideLanguage(@ApplicationContext context: Context): String {
        val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        return sharedPreferences.getString("language", "en") ?: "en"
    }
}