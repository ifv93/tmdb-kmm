package ru.fursa.moviedb.di

import org.koin.dsl.module
import ru.fursa.moviedb.data.remote.MovieApiService
import ru.fursa.moviedb.data.remote.RemoteDataSource
import ru.fursa.moviedb.data.repository.MovieRepositoryImpl
import ru.fursa.moviedb.domain.repository.MovieRepository
import ru.fursa.moviedb.domain.usecase.GetMovieUseCase
import ru.fursa.moviedb.domain.usecase.GetMoviesUseCase
import ru.fursa.moviedb.util.provideDispatcher

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieApiService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(
    domainModule,
    dataModule,
    utilModule
)

fun getSharedModules() = sharedModules