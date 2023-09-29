package ru.fursa.moviedb.android.detail

import ru.fursa.moviedb.domain.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    val movie: Movie? = null,
    var errorMessage: String? = null,
)
