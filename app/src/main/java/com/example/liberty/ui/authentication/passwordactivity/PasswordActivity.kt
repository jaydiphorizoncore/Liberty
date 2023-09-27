package com.example.liberty.ui.authentication.passwordactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.ActivityPasswordBinding
import com.example.liberty.ui.dashboard.MainActivity

class PasswordActivity : AppCompatActivity() {

    companion object {

        const val SHARED_PREFS = "shared_prefs"
        const val PASSWORD_KEY = "password_key"

    }

    private lateinit var binding: ActivityPasswordBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password)

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        clickListener()
    }


    private fun clickListener() {
        binding.btnLoginPassword.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(PASSWORD_KEY, binding.edPassword.text.toString())
            editor.apply()

            if (binding.edPassword.text != null && binding.edPassword.length() >= 8) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                binding.edPassword.error = "Enter Valid Password."
            }
        }

        binding.imgBack.setOnClickListener {
            finish()

        }
    }
}