package com.example.dell.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.tencent.wcdb.DatabaseErrorHandler
import com.tencent.wcdb.database.SQLiteCipherSpec

/**
 * @Title:  kotlin
 * @Package com.example.dell.myapplication
 * @Description:    $todo$
 * @author: L-BackPacker
 * @date:   2019/3/12 21:48
 * @version V 1.0 xxxxxxxx
 * @verdescript  版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
class OpenHelp(
    context: Context?
) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATATABLE_VERSION) {

    companion object {
        var TABLE_NAME: String = "tables"
        var DATABASE_NAME: String = "userinfom.db"
        var DATATABLE_VERSION: Int = 1
        var PASSWORD = "ask".toByteArray()


        @SuppressLint("StaticFieldLeak")
        private var singletonInstance:OpenHelp ?= null

        @Synchronized fun getInstance(m:Context):OpenHelp?{
            if (singletonInstance == null){
                singletonInstance = OpenHelp(m)
            }
            return singletonInstance
        }

    }



    override fun onCreate(db: SQLiteDatabase?) {
        var sql = "create table " + TABLE_NAME + "" +
                "( id Integer primary key autoincrement," +
                "age text," +
                "name text," +
                "class text );"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}