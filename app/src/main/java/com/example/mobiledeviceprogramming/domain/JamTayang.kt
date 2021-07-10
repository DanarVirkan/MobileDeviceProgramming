package com.example.mobiledeviceprogramming.domain

data class JamTayang(
    val idSiaran: String,
    val senin: String? = null,
    val selasa: String? = null,
    val rabu: String? = null,
    val kamis: String? = null,
    val jumat: String? = null,
    val sabtu: String? = null,
    val minggu: String? = null
)
