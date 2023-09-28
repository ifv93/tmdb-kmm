package ru.fursa.moviedb.domain.repository

import ru.fursa.moviedb.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}