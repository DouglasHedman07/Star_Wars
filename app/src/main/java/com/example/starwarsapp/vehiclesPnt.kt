package com.example.starwarsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.Repositorios.VehiclesRepo
import com.example.starwarsapp.gestionDatos.GeterVehicles
import kotlinx.android.synthetic.main.activity_vehicles_pnt.*

class vehiclesPnt : AppCompatActivity() {

    lateinit var rcvStarWarsList : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles_pnt)

        val StarWarsGeter = GeterVehicles.instance
        val StarWarsRepo = VehiclesRepo(StarWarsGeter)
        val StarWarsListAdapter = RecyclerViewAdapterVehicles()

        StarWarsRepo.listarItem {
            if(it != null){
                StarWarsListAdapter.listaStarWars = it
                StarWarsListAdapter.notifyDataSetChanged()
            }
        }

        rcvStarWarsList = rcvVehicles
        rcvStarWarsList.layoutManager = LinearLayoutManager(this)
        rcvStarWarsList.adapter = StarWarsListAdapter

    }
}