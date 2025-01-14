package com.example.domainapp.usecase

import com.example.domainapp.repository.MovieRepository
import com.example.domainapp.util.Result

/**
 * @author by Ali Asadi on 13/08/2022
 */
class CheckFavoriteStatus(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): Result<Boolean> = movieRepository.checkFavoriteStatus(movieId)
}