package com.example.liberty.ui.dashboard.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.data.repository.ApiRepository

class ViewModelFactory(private val apiRepository: ApiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(apiRepository) as T
    }
}