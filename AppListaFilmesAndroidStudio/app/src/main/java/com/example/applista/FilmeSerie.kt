
package com.example.applista

data class FilmeSerie(
    var nome: String,
    var genero: String,
    var assistido: Boolean = false,
    var nota: Double? = null
)
