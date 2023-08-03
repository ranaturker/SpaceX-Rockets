package com.ranaturker.rocketsapp.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranaturker.rocketsapp.network.Rockets
import com.ranaturker.rocketsapp.network.RocketsApiService
import retrofit2.Call
import retrofit2.Response

class ListViewModel : ViewModel() {

    val rocketsLiveData = MutableLiveData<List<Rockets>?>()
    val rockets : LiveData<List<Rockets>?> = rocketsLiveData

    fun getRockets() {
        RocketsApiService.api.getRockets().enqueue(object : retrofit2.Callback<List<Rockets>> {

            override fun onResponse(call: Call<List<Rockets>>, response: Response<List<Rockets>>) {
                if (response.isSuccessful) {
                    val rockets = response.body()
                    rocketsLiveData.postValue(rockets)
                } else {
                    Log.d("failed", "Failed to fetch rockets: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Rockets>>, t: Throwable) {
                Log.d("error", "Error: ${t.message}")
            }
        })
    }
}

