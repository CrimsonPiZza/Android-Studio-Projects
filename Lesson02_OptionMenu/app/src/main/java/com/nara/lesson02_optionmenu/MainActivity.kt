package com.nara.lesson02_optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        //inflate menu into the activity
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.opt1 -> Toast.makeText(this, "Setting",Toast.LENGTH_SHORT).show()
            R.id.opt2 -> Toast.makeText(this, "About",Toast.LENGTH_SHORT).show()
            R.id.opt3 -> Toast.makeText(this, "Exit",Toast.LENGTH_SHORT).show()
            R.id.opt4 -> Toast.makeText(this, "Dark Mode",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}
