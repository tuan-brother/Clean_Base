package com.example.domainapp.usecase

import androidx.paging.PagingData
import com.example.domainapp.entities.MovieEntity
import com.example.domainapp.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author by Ali Asadi on 13/08/2022
 */
class GetFavoriteMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(pageSize: Int): Flow<PagingData<MovieEntity>> = movieRepository.favoriteMovies(pageSize)
}