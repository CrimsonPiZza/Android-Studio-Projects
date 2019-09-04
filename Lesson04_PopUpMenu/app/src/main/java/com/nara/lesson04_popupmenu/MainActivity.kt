package com.nara.lesson04_popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myBtn.setOnClickListener{
            var popUpMenu = PopupMenu(this,it)

            popUpMenu.inflate(R.menu.menu_items)
            popUpMenu.show()

            popUpMenu.setOnMenuItemClickListener {item->
                when(item.itemId){
                    R.id.opt1 -> Toast.makeText(this,"New file",Toast.LENGTH_SHORT).show()
                    R.id.opt2 -> Toast.makeText(this,"New folder",Toast.LENGTH_SHORT).show()
                    R.id.opt3 -> Toast.makeText(this,"New doc",Toast.LENGTH_SHORT).show()
                }
                true
            }
        }
    }


}
