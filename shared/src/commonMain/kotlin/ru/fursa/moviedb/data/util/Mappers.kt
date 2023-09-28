package ru.fursa.moviedb.data.util

import ru.fursa.moviedb.data.remote.MovieResponse
import ru.fursa.moviedb.domain.model.Movie

internal fun MovieResponse.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImageUrl),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImageUrl: String) = "https://image.tmdb.org/t/p/w500/$posterImageUrl"