package com.example.starwarsapp.gestionDatos

data class VehiclesResponse (
    val count: Int,
    val  results: List<StarWarsItem>
) {
    class StarWarsItem(
        val name: String,
    )}
