package com.nara.lesson13_sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {
    lateinit var pref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("myPref", MODE_PRIVATE)
        textView.text = getScore().toString()

        var editor = pref.edit()
        editor.putInt("SCORE",100)
        editor.apply()
    }

    fun getScore():Int = pref.getInt("SCORE",0)

}
