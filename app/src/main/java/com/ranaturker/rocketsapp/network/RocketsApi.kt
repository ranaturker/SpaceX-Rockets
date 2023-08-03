package com.ranaturker.rocketsapp.network

import retrofit2.Call
import retrofit2.http.GET

interface RocketsApi {
    @GET("rockets")
    fun getRockets(): Call<List<Rockets>>
}