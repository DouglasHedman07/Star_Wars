package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.PeopleRepo
import com.example.starwarsapp.gestionDatos.GeterPeople
import kotlinx.android.synthetic.main.activity_people_pnt.*

class peoplePnt : AppCompatActivity() {
    lateinit var rcvStarWarsList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_pnt)

        val StarWarsGeter = GeterPeople.instance
        val StarWarsRepo = PeopleRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterPeople()

        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }
        rcvStarWarsList = rcvPeople
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter
    }
}