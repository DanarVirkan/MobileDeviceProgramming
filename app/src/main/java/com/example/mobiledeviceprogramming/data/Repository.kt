package com.example.mobiledeviceprogramming.data

import com.example.mobiledeviceprogramming.domain.Siaran

class Repository(private val localSource: LocalSource) {
    suspend fun insertSiaran(item: Siaran) {
        localSource.insertSiaran(item)
    }

    fun getTV() = localSource.getTV()
    fun getMovie() = localSource.getMovie()
    fun updateSiaran(item: Siaran) = localSource.updateSiaran(item)
    fun deleteSiaran(item: Siaran) = localSource.deleteSiaran(item)
}