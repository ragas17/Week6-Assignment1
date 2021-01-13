package com.sagar.softuser_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userName = findViewById(R.id.loginUserName)
        password = findViewById(R.id.loginPassword)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (isValidAccount()){
            startActivity(Intent(this, MainActivity::class.java))
        }
        else{
            showAlertError()
        }
    }

    private fun isValidAccount(): Boolean{
        return (userName.text.toString() == "softwarica" || userName.text.toString() == "Softwarica") &&
                (password.text.toString() == "coventry" || password.text.toString() == "Coventry")
    }

    private fun showAlertError(){
        val builder = AlertDialog.Builder(this)

        builder.setTitle("Invalid Account")

        builder.setMessage("Either username or password is incorrect")

        builder.setPositiveButton("Try Again"){ _, _ ->
            userName.requestFocus()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}