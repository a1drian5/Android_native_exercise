package com.anushka.tmdbclient.data.repository.topRateMovie.datasourceImpl

import com.anushka.tmdbclient.data.db.TopRateMovieDao
import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopRateMovieLocalDataSourceImpl(private val topRateMovieDao: TopRateMovieDao) : TopRateMovieLocalDataSource {
    override suspend fun getTopRateMoviesFromDB(): List<TopRateMovie> {
        return topRateMovieDao.getTopRateMovies()
    }

    // Usamos I/O para no bloquear el hilo principal
    override suspend fun saveTopRateMoviesToDB(topRateMovies: List<TopRateMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            topRateMovieDao.saveTopRateMovies(topRateMovies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            topRateMovieDao.deleteAllTopRateMovies()
        }
    }
}