package ru.fursa.moviedb.android.home

import ru.fursa.moviedb.domain.model.Movie

data class HomeScreenState(
    val loading: Boolean = false,
    val refreshing: Boolean = false,
    var movies: List<Movie> = listOf(),
    val errorMessage: String? = null,
    var loadFinished: Boolean = false,
)