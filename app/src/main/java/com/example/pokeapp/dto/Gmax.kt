package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Gmax(
    val regular: String?,
    val shiny: String?
) {
    constructor() : this("","")
}