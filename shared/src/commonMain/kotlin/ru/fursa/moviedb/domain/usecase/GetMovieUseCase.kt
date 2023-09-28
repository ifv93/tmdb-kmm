package ru.fursa.moviedb.domain.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.fursa.moviedb.domain.model.Movie
import ru.fursa.moviedb.domain.repository.MovieRepository

class GetMovieUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }
}