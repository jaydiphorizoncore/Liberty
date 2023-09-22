package com.example.liberty

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.liberty.network.request.LoginRequest
import com.example.liberty.network.response.LoginResponse
import com.example.liberty.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    companion object {

        const val SHARED_PREFS = "shared_prefs"
        const val NUMBER_KEY = "number_key"

    }

    lateinit var btnLoginNumber: Button
    lateinit var edMobileNumber: EditText
    private lateinit var sharedpreferences: SharedPreferences
    private var number: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        number = sharedpreferences.getString("number_key", null)
        password = sharedpreferences.getString("password_key", null)

        checkLogin()
        initView()
        clickListener()



        val loginRequest = LoginRequest(
            "1.3.6",
            "Android SDK built for x86",
            "Android",
            "ad8443137d0f2ebb",
            "Android",
            1,
            "fqUCJxeQQjmuQxQ7oJyV1i:APA91bFnUyxv9E8gWbGfENAwNMWsk65pu-RuqrTBrBdhjxjjEisSKiKdI9W7JcwwPz9DqL8kaxGRq3UAl6T_JKwo8lR1agu6GAvLnqipP7zq2ahqsmZlAII9eVHIZwlnocRvuLWbTIpt",
            "11",
            "login",
            "1212121212"
        )
        val call = RetrofitHelper.apiService.checkUserNAme(loginRequest)
        call.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("ok", "data is : ${data.toString()}")

                    if (data != null) {
                        Toast.makeText(applicationContext, data.data.firstName, Toast.LENGTH_LONG)
                            .show()
                    }
                } else {
                    // Handle errors here
                    val errorBody = response.errorBody()?.string()
                    if (errorBody != null) {
                        Log.e("error", errorBody)
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Log.e("TAG", "onFailure:Fail ")
            }
        })
    }

    private fun checkLogin() {
        if (number != null && password != null) {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    private fun clickListener() {
        btnLoginNumber.setOnClickListener {

            if (numberValidation()) {
                val editor = sharedpreferences.edit()
                editor.putString(NUMBER_KEY, edMobileNumber.text.toString())
                editor.apply()

                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)

            } else {
                edMobileNumber.error = "Enter 10 Digits"
            }
        }
        edMobileNumber.setOnClickListener {
            edMobileNumber.setBackgroundResource(R.color.color_ed_background)
        }
    }


    private fun initView() {
        btnLoginNumber = findViewById(R.id.btn_login_number)
        edMobileNumber = findViewById(R.id.ed_mobile_number)
    }

    private fun numberValidation(): Boolean {
        if (edMobileNumber.text != null && edMobileNumber.length() == 10) {
            return true
        }
        return false
    }

}