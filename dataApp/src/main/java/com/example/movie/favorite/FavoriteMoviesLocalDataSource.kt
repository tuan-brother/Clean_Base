package com.example.movie.favorite

import androidx.paging.PagingSource
import com.aliasadi.data.db.favoritemovies.FavoriteMovieDao
import com.example.entities.FavoriteMovieDbData
import com.example.entities.MovieDbData
import com.example.exception.DataNotAvailableException
import com.example.domainapp.util.Result

/**
 * @author by Ali Asadi on 22/08/2022
 */
class FavoriteMoviesLocalDataSource(
    private val favoriteMovieDao: FavoriteMovieDao,
) : FavoriteMoviesDataSource.Local {

    override fun favoriteMovies(): PagingSource<Int, MovieDbData> = favoriteMovieDao.favoriteMovies()

    override suspend fun addMovieToFavorite(movieId: Int) {
        favoriteMovieDao.add(FavoriteMovieDbData(movieId))
    }

    override suspend fun removeMovieFromFavorite(movieId: Int) {
        favoriteMovieDao.remove(movieId)
    }

    override suspend fun checkFavoriteStatus(movieId: Int): Result<Boolean> {
        return Result.Success(favoriteMovieDao.get(movieId) != null)
    }

    override suspend fun getFavoriteMovieIds(): Result<List<Int>> {
        val movieIds = favoriteMovieDao.getAll().map { it.movieId }
        return if (movieIds.isNotEmpty()) {
            Result.Success(movieIds)
        } else {
            Result.Error(DataNotAvailableException())
        }
    }
}
