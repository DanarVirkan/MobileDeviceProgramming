package com.example.mobiledeviceprogramming.utils

import com.example.mobiledeviceprogramming.domain.JamTayang

object Mapper {
    fun mapJamTayang(obj: JamTayang): Array<Any> {
        val hari = arrayListOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
        )
        var returnedHari = ""
        var returnedJam = ""
        if (!obj.senin.isNullOrEmpty()) {
            returnedHari += "${hari[0]}\n"
            returnedJam += "${obj.senin} WIB\n"
        }
        if (!obj.selasa.isNullOrEmpty()) {
            returnedHari += "${hari[1]}\n"
            returnedJam += "${obj.selasa} WIB\n"
        }
        if (!obj.rabu.isNullOrEmpty()) {
            returnedHari += "${hari[2]}\n"
            returnedJam += "${obj.rabu} WIB\n"
        }
        if (!obj.kamis.isNullOrEmpty()) {
            returnedHari += "${hari[3]}\n"
            returnedJam += "${obj.kamis} WIB\n"
        }
        if (!obj.jumat.isNullOrEmpty()) {
            returnedHari += "${hari[4]}\n"
            returnedJam += "${obj.jumat} WIB\n"
        }
        if (!obj.sabtu.isNullOrEmpty()) {
            returnedHari += "${hari[5]}\n"
            returnedJam += "${obj.sabtu} WIB\n"
        }
        if (!obj.minggu.isNullOrEmpty()) {
            returnedHari += hari[6]
            returnedJam += "${obj.minggu} WIB"
        }
        return arrayOf(returnedHari, returnedJam)
    }

    fun mapGenre(genre: Array<String>, genreChecker: Array<Boolean>): String {
        val genreChecked = arrayListOf<String>()
        for (i in genre.indices) {
            if (genreChecker[i]) {
                genreChecked.add(genre[i])
            }
        }
        if (genreChecked.isEmpty()){
            return "No Genre Selected"
        }
        return genreChecked.joinToString(", ")
    }
}