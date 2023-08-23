package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class NextX(
    val condition: String,
    val name: String,
    val pokedexId: Int
)