package com.puneetkaur.pracmvvmcomplete.api

import com.puneetkaur.pracmvvmcomplete.model.Earthquakes
import retrofit2.Response
import retrofit2.http.GET

interface EarthquakeService {

    @GET("/formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=mkoppelman")
    suspend fun getEarthquakes(): Response<Earthquakes>
}