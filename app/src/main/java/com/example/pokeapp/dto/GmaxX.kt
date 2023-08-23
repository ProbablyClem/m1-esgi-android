package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class GmaxX(
    val regular: String,
    val shiny: String
) {
    constructor() : this("", "")
}