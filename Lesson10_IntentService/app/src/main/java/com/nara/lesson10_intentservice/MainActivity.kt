package com.nara.lesson10_intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    lateinit var i:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        i = Intent(this,MyIntentService::class.java)
    }

    fun control(v:View){
        when(v.id){
            R.id.sStart -> startService(i)
        }
    }
}
