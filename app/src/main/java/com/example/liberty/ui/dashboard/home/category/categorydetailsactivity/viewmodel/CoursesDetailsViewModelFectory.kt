package com.example.liberty.ui.dashboard.home.category.categorydetailsactivity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liberty.data.repository.ApiRepository

class CoursesDetailsViewModelFectory(private val apiRepository: ApiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoursesDetailsViewModel(apiRepository) as T
    }
}