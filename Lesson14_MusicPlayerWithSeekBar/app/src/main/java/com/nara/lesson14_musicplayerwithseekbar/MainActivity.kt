package com.nara.lesson14_musicplayerwithseekbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {
    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
        when(p0?.id){
            R.id.durBar -> mediaPlayer.pause()
        }
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        when(p0?.id){
            R.id.durBar -> {
                mediaPlayer.seekTo(durBar.progress)
                mediaPlayer.start()
            }
        }
    }

    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this,R.raw.mmusic)
        durBar.setOnSeekBarChangeListener(this)
    }



    fun controller(v:View){

        val durChange = Thread({
            durBar.max = mediaPlayer.duration
            while (mediaPlayer.isPlaying){
                durBar.progress = mediaPlayer.currentPosition
            }
        })

        when(v.id){
            R.id.sPlay -> {
                if(!mediaPlayer.isPlaying){
                    mediaPlayer.start()
                    durChange.start()
                }

            }
            R.id.sPause -> {
                mediaPlayer.pause()
            }
            R.id.sStop -> {
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this,R.raw.mmusic)
            }
        }
    }
}
