package com.example.starwarsapp.Repositorios

import com.example.starwarsapp.gestionDatos.GeterSpaceships
import com.example.starwarsapp.gestionDatos.SpaceshipsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpaceshipsRepo(private val StarWarsGeter: GeterSpaceships) {

    fun listarItem(callBack: (List<SpaceshipsResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall = StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<SpaceshipsResponse> {
            override fun onResponse(call: Call<SpaceshipsResponse>, response: Response<SpaceshipsResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<SpaceshipsResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}