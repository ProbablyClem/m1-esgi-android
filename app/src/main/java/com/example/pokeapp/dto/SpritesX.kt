package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class SpritesX(
    val gmax: Gmax? = null,
    val regular: String?,
    val shiny: String?
) {
    constructor() : this(Gmax(),"", "")
}