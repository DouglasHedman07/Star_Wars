package com.example.starwarsapp.Repositorios

import com.example.starwarsapp.gestionDatos.GeterVehicles
import com.example.starwarsapp.gestionDatos.VehiclesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehiclesRepo(private val StarWarsGeter: GeterVehicles) {

    fun listarItem(callBack: (List<VehiclesResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall = StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<VehiclesResponse> {
            override fun onResponse(call: Call<VehiclesResponse>, response: Response<VehiclesResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<VehiclesResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}