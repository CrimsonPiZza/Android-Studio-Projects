package com.nara.lesson12_asynctask

import android.content.Context
import android.os.AsyncTask
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView

class MyTask(context: Context,pBar:ProgressBar,tV:TextView):AsyncTask<Void,Int,String>(){

    var textView = tV
    var progressBar = pBar

    override fun doInBackground(vararg p0: Void?): String {
        for(i in 1..100){
            publishProgress(i)
            Thread.sleep(100)
        }
        return "Finished"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        var pg = values[0]
        progressBar.progress = pg!!
        textView.text = "Download ${pg}%...."
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: String?) {
        textView.text = "Download ${result}!"
        super.onPostExecute(result)
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

}