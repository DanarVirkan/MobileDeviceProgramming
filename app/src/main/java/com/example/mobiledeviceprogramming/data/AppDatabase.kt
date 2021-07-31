package com.example.mobiledeviceprogramming.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobiledeviceprogramming.domain.Siaran

@Database(entities = [Siaran::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun siaranDao(): SiaranDao
}