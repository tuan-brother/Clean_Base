package com.example.domainapp.repository

import androidx.paging.PagingData
import com.example.domainapp.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import com.example.domainapp.util.Result

/**
 * Created by Ali Asadi on 13/05/2020
 */
interface MovieRepository {
    fun movies(pageSize: Int): Flow<PagingData<MovieEntity>>
    fun favoriteMovies(pageSize: Int): Flow<PagingData<MovieEntity>>
    fun search(query: String, pageSize: Int): Flow<PagingData<MovieEntity>>
    suspend fun getMovie(movieId: Int): Result<MovieEntity>
    suspend fun checkFavoriteStatus(movieId: Int): Result<Boolean>
    suspend fun addMovieToFavorite(movieId: Int)
    suspend fun removeMovieFromFavorite(movieId: Int)
    suspend fun sync(): Boolean
}