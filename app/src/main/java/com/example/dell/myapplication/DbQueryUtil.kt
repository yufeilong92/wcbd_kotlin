package com.example.dell.myapplication

import android.database.Cursor


/**
 * @Title:  kotlin
 * @Package com.example.dell.myapplication
 * @Description:    $todo$
 * @author: L-BackPacker
 * @date:   2019/3/12 22:10
 * @version V 1.0 xxxxxxxx
 * @verdescript  版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2019
 */
class DbQueryUtil {
    companion object {//被companion object包裹的语句都是private的

        private var singletonInstance: DbQueryUtil? = null

        @Synchronized
        fun getInstance(): DbQueryUtil? {
            if (singletonInstance == null) {
                singletonInstance = DbQueryUtil()
            }
            return singletonInstance
        }
    }

    private var mQuery: Cursor? = null

    fun initCursor(query: Cursor) {
        this.mQuery = query
    }

    fun queryInt(key: String): Int {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getInt(columnIndex)
    }

    private fun QuesryException() {
        if (mQuery == null) throw NullPointerException("mQuery 不能为空，请执行intCursor()")
    }

    fun queryString(key: String): String {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getString(columnIndex)
    }

    fun queryBLOB(key: String): ByteArray {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getBlob(columnIndex)
    }

    fun querydouble(key: String): Double {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getDouble(columnIndex)
    }

    fun queryFloat(key: String): Float? {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getFloat(columnIndex)
    }

    fun queryLong(key: String): Long? {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getLong(columnIndex)
    }

    fun queryShort(key: String): Short? {
        QuesryException()
        val columnIndex = mQuery!!.getColumnIndex(key)
        return mQuery!!.getShort(columnIndex)
    }


}
