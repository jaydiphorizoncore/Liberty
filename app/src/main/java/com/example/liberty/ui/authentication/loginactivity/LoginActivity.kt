package com.example.liberty.ui.authentication.loginactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.ui.dashboard.MainActivity
import com.example.liberty.ui.authentication.passwordactivity.PasswordActivity
import com.example.liberty.R
import com.example.liberty.databinding.ActivityLoginBinding
import com.example.liberty.data.network.ApiInterface
import com.example.liberty.data.repository.ApiRepository
import com.example.liberty.data.network.response.loginresponse.LoginResponse

class LoginActivity : AppCompatActivity(), LoginInterface {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val NUMBER_KEY = "number_key"
    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedpreferences: SharedPreferences
    private var number: String? = null
    private var password: String? = null

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        number = sharedpreferences.getString("number_key", null)
        password = sharedpreferences.getString("password_key", null)

        checkLogin()
        clickListener()

        val api = ApiInterface()
        val loginRepository = ApiRepository(api)
        val factory = LoginViewModelFactory(loginRepository)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        viewModel.loginInterface = this
        viewModel.getLogin()

    }

    private fun checkLogin() {
        if (number != null && password != null) {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun clickListener() {
        binding.btnLoginNumber.setOnClickListener {

            if (numberValidation()) {
                val editor = sharedpreferences.edit()
                editor.putString(NUMBER_KEY, binding.edMobileNumber.text.toString())
                editor.apply()

                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)

            } else {
                binding.edMobileNumber.error = "Enter 10 Digits"
            }
        }
        binding.edMobileNumber.setOnClickListener {
            binding.edMobileNumber.setBackgroundResource(R.color.color_ed_background)
        }
    }

    private fun numberValidation(): Boolean {
        if (binding.edMobileNumber.text != null && binding.edMobileNumber.length() == 10) {
            return true
        }
        return false
    }

    override fun onStarted() {
        Log.d("TAG", "onStartedLogin")
    }

    override fun onSuccess(loginResponse: LoginResponse?) {
        Log.d("ok", "data is : ${loginResponse.toString()}")
        Log.d("ok", "data is : ${loginResponse!!.data.firstName}")

    }

    override fun onFailure(message: String) {
        Log.e("TAG", "onFailure:Fail ")
    }

}