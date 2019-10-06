package com.nara.sqldbinsertion

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

var DBname = "My Data"
class MyHelper(context: Context):SQLiteOpenHelper(context, DBname,null,1) {

    val TABLE_NAME = "Student_Info"
    val COL1 = "Roll"
    val COL2 = "Sname"
    val COL3 = "School"

    override fun onCreate(p0: SQLiteDatabase?) {
        var createTable = "create table $TABLE_NAME " +
                "($COL1 varchar(250)," +
                "$COL2 varchar(250)," +
                "$COL3 varchar(250))"
        p0?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertData(dto:Student):Long{
        if (readOneRecord(dto.rollnum) != null){
            return -2.toLong()
        }else{
            var cv = ContentValues()
            cv.put(COL1,dto.rollnum)
            cv.put(COL2,dto.name)
            cv.put(COL3,dto.school)

            var db = this.writableDatabase
            return db.insert(TABLE_NAME,null,cv)
        }
    }
//
    fun readOneRecord(roll:String):Student?{
        var db = this.readableDatabase
        var cursor = db.rawQuery("select * from $TABLE_NAME where Roll == '$roll' ",null)
        if (cursor != null){
            if(cursor.moveToFirst()) {
                var roll = cursor.getString(0)
                var name = cursor.getString(1)
                var school = cursor.getString(2)
                return Student(roll, name, school)
            }
        }
        return null

    }

    fun readAllRecord():ArrayList<Student>{
        var db = this.readableDatabase
        var cursor = db.rawQuery("select * from $TABLE_NAME",null)
        var list:ArrayList<Student> = ArrayList<Student>()
        if (cursor != null){
            if(cursor.moveToFirst()){
                do{
                    var roll = cursor.getString(0)
                    var name = cursor.getString(1)
                    var school = cursor.getString(2)
                    list.add(Student(roll,name,school))
                }while(cursor.moveToNext())
            }
        }
        return list
    }
}