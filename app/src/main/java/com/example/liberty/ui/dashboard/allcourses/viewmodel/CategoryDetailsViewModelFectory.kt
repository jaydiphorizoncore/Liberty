package com.example.liberty.ui.dashboard.allcourses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.data.repository.ApiRepository
class CategoryDetailsViewModelFectory(private val apiRepository: ApiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CategoryDetailsViewModel(apiRepository) as T
    }
}