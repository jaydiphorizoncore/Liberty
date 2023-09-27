package com.example.liberty.ui.authentication.loginactivity

import com.example.liberty.data.network.response.loginresponse.LoginResponse

interface LoginInterface {
    fun onStarted()
    fun onSuccess(loginResponse: LoginResponse?)
    fun onFailure(message: String)
}