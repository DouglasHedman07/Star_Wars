package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.PlanetsRepo
import com.example.starwarsapp.gestionDatos.GeterPlanets
import kotlinx.android.synthetic.main.activity_planets_pnt.*

class planetsPnt : AppCompatActivity() {

    lateinit var rcvStarWarsList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planets_pnt)

        val StarWarsGeter = GeterPlanets.instance
        val StarWarsRepo = PlanetsRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterPlanets()

        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }

        rcvStarWarsList = rcvPlanets
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter
    }

    }