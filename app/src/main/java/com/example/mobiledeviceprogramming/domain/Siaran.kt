package com.example.mobiledeviceprogramming.domain

import java.io.Serializable

data class Siaran(
    val idSiaran: String,
    val cover: Int,
    val judul: String,
    val genre: String,
    val synopsis: String,
    val rating: String,
    val tipe: String
) : Serializable