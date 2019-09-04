package com.nara.lesson08_seekbarcolor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {

    var btn:Button? = null

    var red = 0
    var blue = 0
    var green = 0
    var alpha = 0

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        when(p0?.id){
            R.id.redCol -> red = p1
            R.id.greenCol -> green = p1
            R.id.blueCol -> blue = p1
            R.id.alphaCol -> alpha = p1
        }
        btn?.setBackgroundColor(Color.argb(alpha,red,green,blue))
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redCol.setOnSeekBarChangeListener(this)
        greenCol.setOnSeekBarChangeListener(this)
        blueCol.setOnSeekBarChangeListener(this)
        alphaCol.setOnSeekBarChangeListener(this)

        redCol.max = 255
        greenCol.max = 255
        blueCol.max = 255
        alphaCol.max = 255
    }

    fun selectBtn(v:View){
      btn = findViewById<Button>(v.id) as Button
    }
}
