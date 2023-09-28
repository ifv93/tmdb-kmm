package ru.fursa.moviedb.data.remote

import kotlinx.coroutines.withContext
import ru.fursa.moviedb.util.Dispatcher

internal class RemoteDataSource(
    private val apiService: MovieApiService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId = movieId)
    }
}