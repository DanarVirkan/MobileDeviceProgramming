package com.example.mobiledeviceprogramming.utils

import com.example.mobiledeviceprogramming.R
import com.example.mobiledeviceprogramming.domain.JamTayang
import com.example.mobiledeviceprogramming.domain.Siaran

object DataDummy {
    private val idMovie = arrayListOf("M1", "M2", "M3")
    private val coverMovie = arrayListOf(
        R.drawable.mk_175x,
        R.drawable.f9_175x,
        R.drawable.conjuring3_175x
    )
    private val judulMovie =
        arrayListOf("Mortal Kombat", "F9", "The Conjuring: The Devil Made Me Do It")
    private val genreMovie = arrayListOf(
        "Action, Fantasy, Adventure",
        "Action, Adventure, Crime, Thriller",
        "Horror, Mystery, Thriller"
    )
    private val synopsisMovie = arrayListOf(
        "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
        "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
        "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense."
    )
    private val ratingMovie = arrayListOf("R", "PG-13", "R")

    private val coverTV = arrayListOf(
        R.drawable.loki_175x,
    )

    private val idTV = arrayListOf("T1")
    private val judulTV = arrayListOf("Loki")
    private val genreTV = arrayListOf("Drama, Sci-Fi & Fantasy")
    private val synopsisTV =
        arrayListOf("After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.")
    private val ratingTV = arrayListOf("TV-14")

    private val jamMk = JamTayang(idMovie[0], "10.00-12.00")
    private val jamF9 = JamTayang(idMovie[1], rabu = "15.00-18.00")
    private val jamConjuring = JamTayang(idMovie[2], minggu = "21.00-23.00")
    private val jamLoki = JamTayang(
        idTV[0],
        "10.00-11.00",
        "10.00-11.00",
        "13.00-14.00",
        "13.00-14.00",
        "15.00-16.00",
        "08.00-09.00",
        "08.00-09.00"
    )
    private val jamTayang = arrayListOf(jamMk, jamF9, jamConjuring, jamLoki)

//    fun getDataMovie(): ArrayList<Siaran> {
//        val dataArray = ArrayList<Siaran>()
//        for (i in 0 until judulMovie.size) {
//            val siaran = Siaran(
//                idMovie[0],
//                coverMovie[i], judulMovie[i], genreMovie[i],
//                synopsisMovie[i], ratingMovie[i], "Movie"
//            )
//            dataArray.add(siaran)
//        }
//        return dataArray
//    }
//
//    fun getDataTV(): ArrayList<Siaran> {
//        val dataArray = ArrayList<Siaran>()
//        for (i in 0 until judulTV.size) {
//            val siaran =
//                Siaran(
//                    idTV[0],
//                    coverTV[i],
//                    judulTV[i],
//                    genreTV[i],
//                    synopsisTV[i],
//                    ratingTV[i],
//                    "TV"
//                )
//            dataArray.add(siaran)
//        }
//        return dataArray
//    }

    fun getJamTayang(id: String): ArrayList<JamTayang> {
        return jamTayang.filter {
            it.idSiaran == id
        } as ArrayList<JamTayang>
    }

}