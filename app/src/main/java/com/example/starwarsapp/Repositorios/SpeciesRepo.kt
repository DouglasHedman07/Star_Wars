package com.example.starwarsapp.Repositorios

import com.example.starwarsapp.gestionDatos.GeterSpecies
import com.example.starwarsapp.gestionDatos.SpeciesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeciesRepo(private val StarWarsGeter: GeterSpecies) {

    fun listarItem(callBack: (List<SpeciesResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall = StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<SpeciesResponse> {
            override fun onResponse(call: Call<SpeciesResponse>, response: Response<SpeciesResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<SpeciesResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}