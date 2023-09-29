package ru.fursa.moviedb.util

import org.koin.core.context.startKoin
import ru.fursa.moviedb.di.getSharedModules

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}