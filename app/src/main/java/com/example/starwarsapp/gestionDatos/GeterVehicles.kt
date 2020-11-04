package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterVehicles {

    @GET("vehicles/")
    fun listarItem(): Call<VehiclesResponse>

    companion object {
        val instance : GeterVehicles by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterVehicles>(GeterVehicles::class.java)
        }
    }
}