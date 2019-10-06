package com.nara.sqldbinsertion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun insert(v:View){
        var city = citytxt.text.toString()
        var name = nametxt.text.toString()

        var insertData = Student(city,name)

        var helper = MyHelper(this)

        var RESULT = helper.insertData(insertData)

        if (RESULT == -1.toLong()){
            Toast.makeText(this,"Registration failed...",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Registration succeeed at row $RESULT...",Toast.LENGTH_SHORT).show()
        }

    }

    fun viewTable(v: View){
        var db = MyHelper(this)

        var list:ArrayList<Student> = db.readRecord()

        var str = ""

        for (i in list){
            str += (i.city + " : " + i.sname + "\n")
        }
        dataText.text = str
    }
}
