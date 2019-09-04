package com.nara.lesson03_contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(tv)
    }

    override fun onCreateContextMenu(m: ContextMenu?, v: View?, mI: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(m, v, mI)
        menuInflater.inflate(R.menu.menu_items, m)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.opt1 -> Toast.makeText(this, "Call",Toast.LENGTH_SHORT).show()
            R.id.opt2 -> Toast.makeText(this, "Copy",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}
