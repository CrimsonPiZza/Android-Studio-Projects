package com.nara.sqldbinsertion

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
var DBname = "My Data"
class MyHelper(context: Context):SQLiteOpenHelper(context, DBname,null,1) {

    val TABLE_NAME = "Student_Info"
    val COL1 = "City"
    val COL2 = "Sname"

    override fun onCreate(p0: SQLiteDatabase?) {
        var create_table = "create table $TABLE_NAME " +
                "($COL1 varchar(250)," +
                "$COL2 varchar(250))"
        p0?.execSQL(create_table)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertData(dto:Student):Long{
        var cv = ContentValues()
        cv.put("City",dto.city)
        cv.put("Sname",dto.sname)
        var db = this.writableDatabase
        return db.insert(TABLE_NAME,null,cv)
    }

    fun readRecord():ArrayList<Student>{
        var list:ArrayList<Student> = ArrayList<Student>()
        var db = this.readableDatabase
        var cursor = db.rawQuery("select * from $TABLE_NAME",null)


        if (cursor != null){
            if (cursor.moveToFirst()){
                do{
                    var city = cursor.getString(cursor.getColumnIndex(COL1))
                    var name = cursor.getString(cursor.getColumnIndex(COL2))

                    list.add(Student(city,name))

                }while (cursor.moveToNext());
            }
        }
        return list

    }
}