package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterPeople {

    @GET("people/")
    fun listarItem(): Call<PeopleResponse>

    companion object {
        val instance : GeterPeople by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterPeople>(GeterPeople::class.java)
        }
    }
}