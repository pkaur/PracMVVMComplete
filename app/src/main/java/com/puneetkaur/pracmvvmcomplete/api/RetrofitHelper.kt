package com.puneetkaur.pracmvvmcomplete.api

import com.puneetkaur.pracmvvmcomplete.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object{
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy {
            getInstance().create(EarthquakeService::class.java)
        }
    }
}