package com.example.starwarsapp.gestionDatos

data class SpeciesResponse (
    val count: Int,
    val  results: List<StarWarsItem>
) {
    class StarWarsItem(
        val name: String,
    )}