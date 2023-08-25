package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Sprites(
    val regular: String?,
    val shiny: String?
)