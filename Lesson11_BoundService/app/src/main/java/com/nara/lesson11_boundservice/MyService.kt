package com.nara.lesson11_boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return MyBinder()
    }

//    var getBinder = MyBinder()

    inner class MyBinder:Binder(){

        fun getInstance():MyService{
            return MyService()
        }
    }

    fun getTime():String{
        return Date().toString()
    }
}
