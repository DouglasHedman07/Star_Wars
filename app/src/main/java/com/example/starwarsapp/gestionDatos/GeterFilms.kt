package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterFilms {

    @GET("films/")
    fun listarItem(): Call<FilmsResponse>

    companion object {
        val instance : GeterFilms by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterFilms>(GeterFilms::class.java)
        }
    }
}