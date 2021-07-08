package com.example.mobiledeviceprogramming.utils

import com.example.mobiledeviceprogramming.R
import com.example.mobiledeviceprogramming.data.Siaran

object DataDummy {
    val coverMovie = arrayListOf(
        R.drawable.mk_175x,
        R.drawable.f9_175x,
        R.drawable.conjuring3_175x
    )
    val judulMovie = arrayListOf("Mortal Kombat", "F9", "The Conjuring: The Devil Made Me Do It")
    val ratingMovie = arrayListOf("R", "PG-13", "R")

    val coverTV = arrayListOf(
        R.drawable.loki_175x,
    )
    val judulTV = arrayListOf("Loki")
    val ratingTV = arrayListOf("TV-14")

    fun getDataMovie(): ArrayList<Siaran> {
        val dataArray = ArrayList<Siaran>()
        for (i in 0 until judulMovie.size) {
            val siaran = Siaran(coverMovie[i], judulMovie[i], ratingMovie[i], "Movie")
            dataArray.add(siaran)
        }
        return dataArray
    }

    fun getDataTV(): ArrayList<Siaran> {
        val dataArray = ArrayList<Siaran>()
        for (i in 0 until judulTV.size) {
            val siaran = Siaran(coverTV[i], judulTV[i], ratingTV[i], "TV")
            dataArray.add(siaran)
        }
        return dataArray
    }

}