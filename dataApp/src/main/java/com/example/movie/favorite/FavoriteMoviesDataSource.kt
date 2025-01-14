package com.example.movie.favorite

import androidx.paging.PagingSource
import com.example.entities.MovieDbData
import com.example.domainapp.util.Result

/**
 * @author by Ali Asadi on 22/08/2022
 */
interface FavoriteMoviesDataSource {

    interface Local {
        fun favoriteMovies(): PagingSource<Int, MovieDbData>
        suspend fun getFavoriteMovieIds(): Result<List<Int>>
        suspend fun addMovieToFavorite(movieId: Int)
        suspend fun removeMovieFromFavorite(movieId: Int)
        suspend fun checkFavoriteStatus(movieId: Int): Result<Boolean>
    }
}
