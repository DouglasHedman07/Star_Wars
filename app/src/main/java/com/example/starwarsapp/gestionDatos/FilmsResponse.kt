package com.example.starwarsapp.gestionDatos

data class FilmsResponse (
    val count: Int,
    val  results: List<StarWarsItem>
) {
    class StarWarsItem(
        val title: String,
    )}