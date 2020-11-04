package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.SpeciesRepo
import com.example.starwarsapp.gestionDatos.GeterSpecies
import kotlinx.android.synthetic.main.activity_species_pnt.*

class speciesPnt : AppCompatActivity() {
    lateinit var rcvStarWarsList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_species_pnt)

        val StarWarsGeter = GeterSpecies.instance
        val StarWarsRepo = SpeciesRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterSpecies()

        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }

        rcvStarWarsList = rcvSpecies
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter
    }
}