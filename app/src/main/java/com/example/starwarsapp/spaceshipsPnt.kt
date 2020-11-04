package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.SpaceshipsRepo
import com.example.starwarsapp.gestionDatos.GeterSpaceships
import kotlinx.android.synthetic.main.activity_spaceships_pnt.*

class spaceshipsPnt : AppCompatActivity() {
    lateinit var rcvStarWarsList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spaceships_pnt)

        val StarWarsGeter = GeterSpaceships.instance
        val StarWarsRepo = SpaceshipsRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterSpaceships()


        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }

        rcvStarWarsList = rcvSpaceships
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter
    }


}