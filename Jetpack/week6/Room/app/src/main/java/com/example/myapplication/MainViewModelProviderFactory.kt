package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repository.DBRepository

class MainViewModelProviderFactory(
    private val dbRepository: DBRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dbRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}