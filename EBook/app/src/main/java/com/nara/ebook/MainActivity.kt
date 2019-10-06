package com.nara.ebook

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var maxPage = 3
    var currentPage = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPage()
    }

    fun nextPage(v:View){
        if (currentPage == maxPage) currentPage = 1 else currentPage++
        setPage()
    }

    fun previousPage(v:View){
        if (currentPage == 1) currentPage == maxPage else currentPage--
        setPage()
    }

    fun setPage() {
        pageView.setImageResource(findImage(this,"pg$currentPage"))
    }

    fun findImage(context:Context,name:String):Int{
        return context.getResources().getIdentifier(name,
            "drawable", context.getPackageName());
    }
}
