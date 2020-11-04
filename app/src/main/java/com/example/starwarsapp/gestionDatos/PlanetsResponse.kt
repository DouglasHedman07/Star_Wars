package com.example.starwarsapp.gestionDatos

data class PlanetsResponse (
    val count: Int,
    val  results: List<StarWarsItem>
) {
    class StarWarsItem(
        val name: String,
    )}
