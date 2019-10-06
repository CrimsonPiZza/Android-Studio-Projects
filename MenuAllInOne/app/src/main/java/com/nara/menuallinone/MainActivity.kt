package com.nara.menuallinone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(btn)
        btn.setOnClickListener{
            var popupMenu = PopupMenu(this,it)

            popupMenu.inflate(R.menu.menu_items)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {item ->
                when(item.itemId){
                    R.id.op1 -> makeToast("Hi")
                    R.id.op2 -> makeToast("Hello")
                    R.id.op3 -> makeToast("Hola")
                }
                true
            }
        }
    }

    // Option Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.op1 -> makeToast("Hi")
            R.id.op2 -> makeToast("Hello")
            R.id.op3 -> makeToast("Hola")
        }
        return super.onOptionsItemSelected(item)
    }
    // End of Option Menu

    // Context Menu

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.menu_items,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.op1 -> makeToast("Hi")
            R.id.op2 -> makeToast("Hello")
            R.id.op3 -> makeToast("Hola")
        }
        return super.onContextItemSelected(item)
    }

    // End of Context Menu

    fun makeToast(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }
}
