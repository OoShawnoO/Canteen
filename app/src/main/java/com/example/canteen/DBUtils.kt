package com.example.canteen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBUtils(
    context: Context?,
    name: String?,
    version: Int
) : SQLiteOpenHelper(context, name, null,version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ${Set.TABLE} (\n" +
                "\t${Set.COL_ID} integer PRIMARY KEY autoincrement,\n" +
                "\t${Set.COL_NAME} text,\n" +
                "\t${Set.COL_PRICE} text,\n" +
                "\t${Set.COL_COUNT} integer,\n" +
                "\t${Set.COL_IMAGE} integer)")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}