package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterSpecies {

    @GET("species/")
    fun listarItem(): Call<SpeciesResponse>

    companion object {
        val instance : GeterSpecies by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterSpecies>(GeterSpecies::class.java)
        }
    }
}