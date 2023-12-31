package ru.fursa.moviedb.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.fursa.moviedb.domain.usecase.GetMovieUseCase

class DetailViewModel(
    val getMovieUseCase: GetMovieUseCase,
    val movieId: Int,
): ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId = movieId)
    }
    private fun loadMovie(movieId: Int) {
       viewModelScope.launch {
           uiState = uiState.copy(loading = true)

           uiState = try {
               val movie = getMovieUseCase(movieId = movieId)
               uiState.copy(loading = false, movie = movie)
           } catch (e: Throwable) {
                uiState.copy(
                    loading = false,
                    errorMessage = "Could not load the movie ${e.localizedMessage}"
                )
           }
       }
    }
}