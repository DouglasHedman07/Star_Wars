package com.example.starwarsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.gestionDatos.PeopleResponse

class RecyclerViewAdapterPeople : RecyclerView.Adapter<StarWarsListViewHolder>() {
    var listaStarWars = listOf<PeopleResponse.StarWarsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.starwars_datos_view_holder,parent,false)
        return StarWarsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarWarsListViewHolder, position: Int) {
        holder.nombreElemento.text = listaStarWars[position].name
    }

    override fun getItemCount(): Int {
        return listaStarWars.size
    }
}