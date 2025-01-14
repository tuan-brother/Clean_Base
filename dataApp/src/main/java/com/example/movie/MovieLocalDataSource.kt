package com.example.movie

import androidx.paging.PagingSource
import com.aliasadi.data.db.movies.MovieDao
import com.aliasadi.data.db.movies.MovieRemoteKeyDao
import com.example.domainapp.entities.MovieEntity
import com.example.entities.MovieData
import com.example.entities.MovieDbData
import com.example.entities.MovieRemoteKeyDbData
import com.example.entities.toDbData
import com.example.entities.toDomain
import com.example.exception.DataNotAvailableException
import com.example.domainapp.util.Result

/**
 * Created by Ali Asadi on 13/05/2020
 */
class MovieLocalDataSource(
    private val movieDao: MovieDao,
    private val remoteKeyDao: MovieRemoteKeyDao,
) : MovieDataSource.Local {

    override fun movies(): PagingSource<Int, MovieDbData> = movieDao.movies()

    override suspend fun getMovies(): Result<List<MovieEntity>> {
        val movies = movieDao.getMovies()
        return if (movies.isNotEmpty()) {
            Result.Success(movies.map { it.toDomain() })
        } else {
            Result.Error(DataNotAvailableException())
        }
    }

    override suspend fun getMovie(movieId: Int): Result<MovieEntity> {
        return movieDao.getMovie(movieId)?.let {
            Result.Success(it.toDomain())
        } ?: Result.Error(DataNotAvailableException())
    }

    override suspend fun saveMovies(movies: List<MovieData>) {
        movieDao.saveMovies(movies.map { it.toDbData() })
    }

    override suspend fun getLastRemoteKey(): MovieRemoteKeyDbData? {
        return remoteKeyDao.getLastRemoteKey()
    }

    override suspend fun saveRemoteKey(key: MovieRemoteKeyDbData) {
        remoteKeyDao.saveRemoteKey(key)
    }

    override suspend fun clearMovies() {
        movieDao.clearMoviesExceptFavorites()
    }

    override suspend fun clearRemoteKeys() {
        remoteKeyDao.clearRemoteKeys()
    }
}