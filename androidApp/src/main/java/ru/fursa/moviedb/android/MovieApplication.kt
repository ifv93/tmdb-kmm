package ru.fursa.moviedb.android

import android.app.Application
import org.koin.core.context.startKoin
import ru.fursa.moviedb.android.di.appModule
import ru.fursa.moviedb.di.getSharedModules

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}