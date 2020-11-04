package com.example.starwarsapp.gestionDatos

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GeterSpaceships {

    @GET("starships/")
    fun listarItem(): Call<SpaceshipsResponse>

    companion object {
        val instance : GeterSpaceships by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<GeterSpaceships>(GeterSpaceships::class.java)
        }
    }
}