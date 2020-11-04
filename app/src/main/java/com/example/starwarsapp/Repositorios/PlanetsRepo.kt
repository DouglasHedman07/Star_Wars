package com.example.starwarsapp.Repositorios


import com.example.starwarsapp.gestionDatos.GeterPlanets
import com.example.starwarsapp.gestionDatos.PlanetsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetsRepo(private val StarWarsGeter: GeterPlanets) {

    fun listarItem(callBack: (List<PlanetsResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall = StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<PlanetsResponse> {
            override fun onResponse(call: Call<PlanetsResponse>, response: Response<PlanetsResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<PlanetsResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}