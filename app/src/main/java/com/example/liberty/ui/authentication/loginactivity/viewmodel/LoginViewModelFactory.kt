package com.example.liberty.ui.authentication.loginactivity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.data.repository.ApiRepository

class LoginViewModelFactory(private val apiRepository: ApiRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(apiRepository) as T
    }
}