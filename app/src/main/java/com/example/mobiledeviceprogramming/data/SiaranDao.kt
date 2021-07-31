package com.example.mobiledeviceprogramming.data

import androidx.room.*
import com.example.mobiledeviceprogramming.domain.Siaran
import kotlinx.coroutines.flow.Flow

@Dao
interface SiaranDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSiaran(item: Siaran)

    @Query("SELECT * FROM siaran WHERE tipe='TV'")
    fun getTV(): Flow<List<Siaran>>

    @Query("SELECT * FROM siaran WHERE tipe='Movie'")
    fun getMovie(): Flow<List<Siaran>>

    @Update
    fun updateSiaran(item: Siaran)

    @Delete
    fun deleteSiaran(item: Siaran)
}