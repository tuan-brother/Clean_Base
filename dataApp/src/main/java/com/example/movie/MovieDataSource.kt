package com.example.movie

import androidx.paging.PagingSource
import com.example.domainapp.entities.MovieEntity
import com.example.entities.MovieData
import com.example.entities.MovieDbData
import com.example.entities.MovieRemoteKeyDbData
import com.example.domainapp.util.Result

/**
 * Created by Ali Asadi on 13/05/2020
 */
interface MovieDataSource {

    interface Remote {
        suspend fun getMovies(page: Int, limit: Int): Result<List<MovieData>>
        suspend fun getMovies(movieIds: List<Int>): Result<List<MovieData>>
        suspend fun getMovie(movieId: Int): Result<MovieData>
        suspend fun search(query: String, page: Int, limit: Int): Result<List<MovieData>>
    }

    interface Local {
        fun movies(): PagingSource<Int, MovieDbData>
        suspend fun getMovies(): Result<List<MovieEntity>>
        suspend fun getMovie(movieId: Int): Result<MovieEntity>
        suspend fun saveMovies(movies: List<MovieData>)
        suspend fun getLastRemoteKey(): MovieRemoteKeyDbData?
        suspend fun saveRemoteKey(key: MovieRemoteKeyDbData)
        suspend fun clearMovies()
        suspend fun clearRemoteKeys()
    }
}