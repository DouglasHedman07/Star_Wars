package com.example.starwarsapp.gestionDatos

data class SpaceshipsResponse (
    val count: Int,
    val  results: List<StarWarsItem>
) {
    class StarWarsItem(
        val name: String,
    )}
