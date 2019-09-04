package com.nara.lesson10_intentservice

import android.app.IntentService
import android.content.ComponentCallbacks2
import android.content.Intent
import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast

class MyIntentService : IntentService("Daemon"){

    override fun onHandleIntent(p0: Intent?) {
        Thread.sleep(10000)
    }


}