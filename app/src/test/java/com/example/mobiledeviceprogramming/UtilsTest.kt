package com.example.mobiledeviceprogramming

import com.example.mobiledeviceprogramming.domain.JamTayang
import com.example.mobiledeviceprogramming.utils.DataDummy
import com.example.mobiledeviceprogramming.utils.Mapper
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UtilsTest {
    @Test
    fun getJamTayang_is_correct() {
        val jamTayang = DataDummy.getJamTayang("T1")
        assertEquals(
            arrayListOf(
                JamTayang(
                    "T1",
                    "10.00-11.00",
                    "10.00-11.00",
                    "13.00-14.00",
                    "13.00-14.00",
                    "15.00-16.00",
                    "08.00-09.00",
                    "08.00-09.00"
                )
            ), jamTayang
        )
    }

    @Test
    fun jamTayangMapper_is_correct() {
        val jamTayang = JamTayang(
            "T1",
            "10.00-11.00",
            "10.00-11.00",
            "13.00-14.00",
            "13.00-14.00",
            "15.00-16.00",
            "08.00-09.00",
            "08.00-09.00"
        )
        val mappedJamTayang = Mapper.mapJamTayang(jamTayang)
        val returnedHari = """
            Monday
            Tuesday
            Wednesday
            Thursday
            Friday
            Saturday
            Sunday
        """.trimIndent()
        val returnedString = """
            10.00-11.00 WIB
            10.00-11.00 WIB
            13.00-14.00 WIB
            13.00-14.00 WIB
            15.00-16.00 WIB
            08.00-09.00 WIB
            08.00-09.00 WIB
        """.trimIndent()
        assertEquals(returnedHari, mappedJamTayang[0])
        assertEquals(returnedString, mappedJamTayang[1])
    }
}