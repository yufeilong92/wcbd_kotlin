package com.example.dell.myapplication

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun text() {
        var map = TreeMap<Int, String>()
        for (it in 0..40) {
            map.put(it, "值" + it)
        }
        for ((id, value) in map) {
            println("$id 等于 $value")
        }
    }

    @Test
    fun main() {
        val staus = staus.星期一
        println("${staus.name} ${staus.ordinal} ")
    }

    open class Base {
        open fun fite() {}
    }

    abstract class a : Base() {
        override fun fite() {
            super.fite()
        }
    }

    enum class staus {
        星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
    }

    fun MutableList<String>.swap(a: Int, b: Int) {
        var tmp = this[a]
        this[a] = this[b]
        this[b] = tmp
    }

    @Test
    fun texts() {
        var mulit = mutableListOf<String>("1", "2", "3", "4")
        for (item in mulit) {
            println(item)
        }
        mulit.swap(3, 2)
        println("===========")
        for (item in mulit) {
            println(item)
        }
    }

    @Test
    fun s() {
        var  boxl:Gm<Int>  =  Gm(20)
        val c:Gm<String> =Gm("222")
        println("${boxl.value}${c.value}")
    }

    fun a(id: Int) {
        var ma: Int = when (id) {
            1 -> 33
            2 -> 44
            3 -> 55

            else -> 0
        }
        println(ma)

    }

    class Gm<T>(t: T) {
        var value = t
    }

}
