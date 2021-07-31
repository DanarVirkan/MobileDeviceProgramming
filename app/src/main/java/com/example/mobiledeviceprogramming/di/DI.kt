package com.example.mobiledeviceprogramming.di

import androidx.room.Room
import com.example.mobiledeviceprogramming.data.AppDatabase
import com.example.mobiledeviceprogramming.data.LocalSource
import com.example.mobiledeviceprogramming.data.Repository
import com.example.mobiledeviceprogramming.presentation.DetailsViewModel
import com.example.mobiledeviceprogramming.presentation.InputViewModel
import com.example.mobiledeviceprogramming.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    factory {
        get<AppDatabase>().siaranDao()
    }
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "siaran").build()
    }
}

val repositoryModule = module {
    single {
        LocalSource(get())
    }
    single {
        Repository(get())
    }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { InputViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}