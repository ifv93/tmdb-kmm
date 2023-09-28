package ru.fursa.moviedb.data.repository

import ru.fursa.moviedb.data.remote.RemoteDataSource
import ru.fursa.moviedb.data.util.toMovie
import ru.fursa.moviedb.domain.model.Movie
import ru.fursa.moviedb.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map { response ->
            response.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}