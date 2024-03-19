package com.puneetkaur.pracmvvmcomplete.repository

import com.puneetkaur.pracmvvmcomplete.api.RetrofitHelper
import com.puneetkaur.pracmvvmcomplete.model.Earthquakes
import retrofit2.Response

class EarthquakeRepository {

    suspend fun getAllEarthquakes(): Response<Earthquakes> = RetrofitHelper.api.getEarthquakes()
}