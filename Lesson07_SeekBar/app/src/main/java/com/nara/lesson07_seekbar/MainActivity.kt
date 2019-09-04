package com.nara.lesson07_seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        when(p0?.id){
            R.id.sB -> TextView.text = "Currently at : " + p1.toString()
            R.id.sB2 -> TextView.text = "Currently at : " + p1.toString()
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        when(p0?.id){
            R.id.sB -> TextView.text = "Start at : " + sB.progress.toString()
            R.id.sB2 -> TextView.text = "Start at : " + sB2.progress.toString()
        }
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        when(p0?.id){
            R.id.sB -> TextView.text = "Stop at : " + sB.progress.toString()
            R.id.sB2 -> TextView.text = "Stop at :" + sB2.progress.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sB.max = 1000
//        seekBar.isIndeterminate = true
        sB.setOnSeekBarChangeListener(this)
        sB2.setOnSeekBarChangeListener(this)
    }
}
