package com.nara.lesson06_checkbox

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

    fun showState(v:View){
        when(v.id){
            R.id.checkBox1 -> Toast.makeText(this,"CheckBox 1 state is : " + checkBox1.isChecked, Toast.LENGTH_SHORT).show()
            R.id.checkBox2 -> Toast.makeText(this,"CheckBox 2 state is : " + checkBox2.isChecked, Toast.LENGTH_SHORT).show()
        }
    }
}
