package com.example.mobiledeviceprogramming.data

import com.example.mobiledeviceprogramming.domain.Siaran

class LocalSource(private val siaranDao: SiaranDao) {

    suspend fun insertSiaran(item: Siaran) {
        siaranDao.insertSiaran(item)
    }

    fun getTV() = siaranDao.getTV()
    fun getMovie() = siaranDao.getMovie()
    fun updateSiaran(item: Siaran) = siaranDao.updateSiaran(item)
    fun deleteSiaran(item: Siaran) = siaranDao.deleteSiaran(item)
}