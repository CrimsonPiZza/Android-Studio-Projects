package com.nara.lesson12_asynctask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startAsync(v: View){

        var i = Intent(this,MyTask::class.java)

        var myTask = MyTask(this,pgBar,textView)
        myTask.execute()

    }
}
