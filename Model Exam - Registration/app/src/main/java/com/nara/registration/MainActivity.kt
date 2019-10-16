package com.nara.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun register(v: View){
        var i = Intent(this,Main2Activity::class.java)
        var username = userTxt.text.toString()
        var phone = phoneTxt.text.toString()
        var email = emailTxt.text.toString()

        if (checkUsername(username)){
            if (checkNumber(phone)){
                if (checkEmail(email)){
                    makeToast("Registration Complete")
                    startActivity(i)
                }else makeToast("Invalid Email")
            }else makeToast("Invalid Phone Number")
        }else makeToast("Invalid Username")

    }

    fun makeToast(str:String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }

    fun checkUsername(str:String):Boolean{
        if (str != ""){
            for (x in str){
                if (!x.isLetter()){
                    return false
                }
            }
        }else return false
        return true
    }

    fun checkNumber(num:String):Boolean{
        return num.length <= 10 && num != ""
    }

    fun checkEmail(str:String):Boolean{
        for (x in str){
            if (x.toString() == "@"){
                for (y in str){
                    if (y.toString() == "."){
                        return true
                    }
                }
            }
        }
        return false
    }

}
