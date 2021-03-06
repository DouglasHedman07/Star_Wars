package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterPlanets {

    @GET("planets/")
    fun listarItem(): Call<PlanetsResponse>

    companion object {
        val instance : GeterPlanets by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterPlanets>(GeterPlanets::class.java)
        }
    }
}