package com.example.starwarsapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StarWarsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val nombreElemento = itemView.findViewById<TextView>(R.id.txtNombre)
    val nombreElemento2 = itemView.findViewById<TextView>(R.id.txtNombre)
}
