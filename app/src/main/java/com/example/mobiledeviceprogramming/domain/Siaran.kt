package com.example.mobiledeviceprogramming.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Siaran(
    @PrimaryKey(autoGenerate = true)
    val idSiaran: Int?,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val cover: ByteArray?,
    val judul: String,
    val genre: String,
    val synopsis: String,
    val rating: String,
    val tipe: String,
    val jadwal: String
) : Serializable