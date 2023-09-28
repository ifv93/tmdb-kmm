package ru.fursa.moviedb.domain.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.fursa.moviedb.domain.model.Movie
import ru.fursa.moviedb.domain.repository.MovieRepository

class GetMoviesUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page = page)
    }
}