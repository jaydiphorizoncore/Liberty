package com.example.liberty

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class PasswordActivity : AppCompatActivity() {

    companion object {

        const val SHARED_PREFS = "shared_prefs"
        const val PASSWORD_KEY = "password_key"

    }

    lateinit var btnLoginPassword: Button
    lateinit var edPassword: EditText
    lateinit var imgBack: ImageView
    private lateinit var sharedpreferences: SharedPreferences
    private var password: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
       // password = sharedpreferences.getString("number_key", null)

        initView()
        clickListener()
    }

    private fun initView() {
        btnLoginPassword = findViewById(R.id.btn_login_password)
        edPassword = findViewById(R.id.ed_password)
        imgBack = findViewById(R.id.img_back)
    }

    private fun clickListener() {
        btnLoginPassword.setOnClickListener {
            val editor = sharedpreferences.edit()
            editor.putString(PASSWORD_KEY, edPassword.text.toString())
            editor.apply()

            if (edPassword.text != null && edPassword.length() >= 8) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                edPassword.error = "Enter Valid Password."
            }
        }

        imgBack.setOnClickListener {
            finish()

        }
    }


}