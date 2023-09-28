package ru.fursa.moviedb.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieResponse(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterImageUrl: String,
    @SerialName("release_date")
    val releaseDate: String,
)