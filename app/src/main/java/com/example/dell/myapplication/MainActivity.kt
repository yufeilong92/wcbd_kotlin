package com.example.dell.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun send(){
        var  a:Parent=Parent.age();
        a.a()
        var map=TreeMap<Int,String >()
        for(it in 0..40){
        map.put(it,"值it")
        }

        val name=DanLi
        name.age()
        name.name()
        name.sex()


    }

}
