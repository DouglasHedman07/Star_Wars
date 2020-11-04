package com.example.starwarsapp.Repositorios

import com.example.starwarsapp.gestionDatos.GeterPeople
import com.example.starwarsapp.gestionDatos.PeopleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeopleRepo(private val StarWarsGeter: GeterPeople) {

    fun listarItem(callBack: (List<PeopleResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall= StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<PeopleResponse> {
            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}
