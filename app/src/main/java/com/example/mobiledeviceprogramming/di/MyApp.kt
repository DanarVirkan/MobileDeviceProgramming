package com.example.mobiledeviceprogramming.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    databaseModule, repositoryModule, viewModelModule
                )
            )
        }
    }
}