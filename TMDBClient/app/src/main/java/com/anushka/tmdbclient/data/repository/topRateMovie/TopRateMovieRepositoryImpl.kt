package com.anushka.tmdbclient.data.repository.topRateMovie

import android.util.Log
import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieCacheDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieLocalDataSource
import com.anushka.tmdbclient.data.repository.topRateMovie.datasource.TopRateMovieRemoteDatasource
import com.anushka.tmdbclient.domain.repository.TopRateMovieRepository
import java.lang.Exception

class TopRateMovieRepositoryImpl(
    private val topRateMovieRemoteDatasource: TopRateMovieRemoteDatasource,
    private val topRateMovieLocalDataSource: TopRateMovieLocalDataSource,
    private val topRateMovieCacheDataSource: TopRateMovieCacheDataSource
) : TopRateMovieRepository {

    override suspend fun getTopRateMovies(): List<TopRateMovie>? {
        return getTopRateMoviesFromCache()
    }

    override suspend fun updateTopRateMovies(): List<TopRateMovie>? {
        val newListOfTopRateMovies = getTopRateMoviesFromAPI()
        topRateMovieLocalDataSource.clearAll()
        topRateMovieLocalDataSource.saveTopRateMoviesToDB(newListOfTopRateMovies)
        topRateMovieCacheDataSource.saveTopRateMoviesToCache(newListOfTopRateMovies)
        return newListOfTopRateMovies
    }

    suspend fun getTopRateMoviesFromAPI(): List<TopRateMovie> {
        lateinit var topRateMovieList: List<TopRateMovie>
        try {
            val response = topRateMovieRemoteDatasource.getTopRateMovies()
            val body = response.body()
            if(body!=null){
                topRateMovieList = body.topRateMovies
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return topRateMovieList
    }

    suspend fun getTopRateMoviesFromDB():List<TopRateMovie>{
        lateinit var topRateMovieList: List<TopRateMovie>
        try {
            topRateMovieList = topRateMovieLocalDataSource.getTopRateMoviesFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(topRateMovieList.size>0){
            return topRateMovieList
        }else{
            topRateMovieList=getTopRateMoviesFromAPI()
            topRateMovieLocalDataSource.saveTopRateMoviesToDB(topRateMovieList)
        }

        return topRateMovieList
    }

    suspend fun getTopRateMoviesFromCache():List<TopRateMovie>{
        lateinit var topRateMovieList: List<TopRateMovie>
        try {
            topRateMovieList =topRateMovieCacheDataSource.getTopRateMoviesFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(topRateMovieList.size>0){
            return topRateMovieList
        }else{
            topRateMovieList=getTopRateMoviesFromDB()
            topRateMovieCacheDataSource.saveTopRateMoviesToCache(topRateMovieList)
        }

        return topRateMovieList
    }
}