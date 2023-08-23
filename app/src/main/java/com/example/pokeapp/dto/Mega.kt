package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Mega(
    val orbe: String,
    val sprites: Sprites
)