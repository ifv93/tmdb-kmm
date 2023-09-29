package ru.fursa.moviedb.android.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.fursa.moviedb.android.detail.DetailViewModel
import ru.fursa.moviedb.android.home.HomeViewModel

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}