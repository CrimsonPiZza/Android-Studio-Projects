package com.nara.studentquery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nara.sqldbinsertion.MyHelper
import com.nara.sqldbinsertion.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun insert(v: View){
        var roll = rollTxt.text.toString()
        var name = nameTxt.text.toString()
        var school = schoolTxt.text.toString()

        var insertData = Student(roll,name,school)
        var helper = MyHelper(this)
        var RESULT = helper.insertData(insertData)

        if (RESULT == -1.toLong()){
            Toast.makeText(this,"Error Occured during insertion",Toast.LENGTH_SHORT).show()
        }else if(RESULT == -2.toLong()){
            Toast.makeText(this,"$roll already existed",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Added $roll",Toast.LENGTH_SHORT).show()
        }
    }

    fun readOne(v:View){
        var db = MyHelper(this)
        var result:Student? = db.readOneRecord(rollSearchTxt.text.toString())

        resultTxt.text = result?.rollnum + " : " + result?.name + " : " + result?.school
    }

    fun readAll(v:View){
        var db = MyHelper(this)
        var result:ArrayList<Student> = db.readAllRecord()
        var str = ""
        for( x in result){
            str += x.rollnum + " : " + x.name + " : " + x.school + "\n"
        }
        resultTxt.text = str
    }
}
