package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Pre(
    val name: String,
    val pokedexId: Int
)