package com.example.domainapp.usecase

import com.example.domainapp.entities.MovieEntity
import com.example.domainapp.repository.MovieRepository
import com.example.domainapp.util.Result

/**
 * Created by Ali Asadi on 13/05/2020
 **/
class GetMovieDetails(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): Result<MovieEntity> = movieRepository.getMovie(movieId)
}
