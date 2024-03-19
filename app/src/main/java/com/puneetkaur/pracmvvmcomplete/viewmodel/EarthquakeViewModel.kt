package com.puneetkaur.pracmvvmcomplete.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puneetkaur.pracmvvmcomplete.model.Earthquakes
import com.puneetkaur.pracmvvmcomplete.repository.EarthquakeRepository
import kotlinx.coroutines.launch
import com.puneetkaur.pracmvvmcomplete.utils.Result

class EarthquakeViewModel(private val repo: EarthquakeRepository): ViewModel() {

    private val _earthquakes = MutableLiveData<Result<Earthquakes>>()
    val earthquakes = _earthquakes

    init {
        getAllEarthquakes()
    }

    private fun getAllEarthquakes(){
        viewModelScope.launch {
           val earthquakes =  repo.getAllEarthquakes()

            if(earthquakes.isSuccessful){
                val result = earthquakes.body()

                result?.let { _earthquakes.postValue(Result.Success(result!!)) }
            } else {
                _earthquakes.postValue(Result.Failure("Error fetching api response"))
            }
        }
    }
}