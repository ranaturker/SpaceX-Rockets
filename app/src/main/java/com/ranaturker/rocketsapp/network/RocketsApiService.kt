package com.ranaturker.rocketsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RocketsApiService {
    val api:RocketsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RocketsApi::class.java)
    }
}