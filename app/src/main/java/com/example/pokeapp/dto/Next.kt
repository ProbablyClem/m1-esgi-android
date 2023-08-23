package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Next(
    val condition: String,
    val name: String,
    val pokedexId: Int
) {
    constructor() : this("", "", 0)
}