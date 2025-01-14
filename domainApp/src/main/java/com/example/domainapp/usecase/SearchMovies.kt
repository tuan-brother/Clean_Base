package com.example.domainapp.usecase

import androidx.paging.PagingData
import com.example.domainapp.entities.MovieEntity
import com.example.domainapp.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author by Ali Asadi on 24/09/2022
 */
class SearchMovies(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String, pageSize: Int): Flow<PagingData<MovieEntity>> = movieRepository.search(query, pageSize)
}
