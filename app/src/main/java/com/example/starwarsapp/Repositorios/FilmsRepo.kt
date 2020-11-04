package com.example.starwarsapp.Repositorios

import com.example.starwarsapp.gestionDatos.FilmsResponse
import com.example.starwarsapp.gestionDatos.GeterFilms
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsRepo(private val StarWarsGeter: GeterFilms) {

    fun listarItem(callBack: (List<FilmsResponse.StarWarsItem>?)-> Unit){
        val StarWarsCall = StarWarsGeter.listarItem()
        StarWarsCall.enqueue(object: Callback<FilmsResponse> {
            override fun onResponse(call: Call<FilmsResponse>, response: Response<FilmsResponse>) {
                val body = response?.body()
                callBack(body?.results)
            }

            override fun onFailure(call: Call<FilmsResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}