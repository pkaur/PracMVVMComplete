package com.puneetkaur.pracmvvmcomplete.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puneetkaur.pracmvvmcomplete.repository.EarthquakeRepository

class ViewModelFactory(private val repository: EarthquakeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EarthquakeViewModel(repository) as T
    }
}