package com.nara.lesson09_backgroundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service(){

    lateinit var mediaplayer:MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        mediaplayer = MediaPlayer.create(this,R.raw.music)
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaplayer.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mediaplayer.stop()
        super.onDestroy()
    }
}
