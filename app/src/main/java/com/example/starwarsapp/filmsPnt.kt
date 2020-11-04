package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.FilmsRepo
import com.example.starwarsapp.gestionDatos.GeterFilms
import kotlinx.android.synthetic.main.activity_films_pnt.*

class filmsPnt : AppCompatActivity() {

    lateinit var rcvStarWarsList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films_pnt)

        val StarWarsGeter = GeterFilms.instance
        val StarWarsRepo = FilmsRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterFilms()

        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }
        rcvStarWarsList = rcvFilms
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter
    }
}