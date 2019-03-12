package com.example.dell.myapplication

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initEvent()
    }

    fun initEvent() {
        val openHelp = OpenHelp.getInstance(this)
        val database = openHelp!!.writableDatabase
        val dbQueryUtil = DbQueryUtil.getInstance()
        btn_add.setOnClickListener {
            for (item in 0..10) {
                var values = ContentValues()
                values.put("age", "o$item")
                values.put("name", "$item")
                values.put("class", "class$item")
                database.insert(
                    OpenHelp.TABLE_NAME,
                    null, values
                )
            }

        }
        btn_upate.setOnClickListener {
            var values = ContentValues()
            values.put("age", "22222222222222")
            var wherclause: String = "name=?"
            var select = arrayOf("3")
            database.beginTransaction()
            database.update(
                OpenHelp.TABLE_NAME,
                values, wherclause, select
            )
            database.setTransactionSuccessful()
            database.endTransaction()
        }
        btn_query.setOnClickListener {
            val query = database.query(
                OpenHelp.TABLE_NAME,
                null, null, null, null, null
                , null
            )

            dbQueryUtil.let {
                it!!.initCursor(query)
                var data = arrayListOf<UserInfom>()
                while (query.moveToNext()) {
                    val infom = getUserInfom(dbQueryUtil!!)
                    data.add(infom)
                }
                var buffer = StringBuffer()
                for (item in data) {
                    buffer.append(item.age)
                    buffer.append(item.name)
                    buffer.append(item.classs)
                    buffer.append("=====\n")
                }
                tv_show.text = buffer.toString()
            }

        }
        btn_delete.setOnClickListener {
            database.delete(OpenHelp.TABLE_NAME, null, null)
        }
    }

    private fun getUserInfom(mqu: DbQueryUtil): UserInfom {
        var vo = UserInfom()
        val age = mqu.queryString("age")
        val classs = mqu.queryString("class")
        val name = mqu.queryString("name")
        vo.name = name
        vo.age = age
        vo.classs = classs
        return vo
    }

    private class UserInfom(
        var classs: String? = "",

        var name: String = "",

        var age: String = ""
    )
}
