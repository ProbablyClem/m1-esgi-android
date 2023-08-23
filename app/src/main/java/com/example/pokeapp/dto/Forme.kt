package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Forme(
    val forme: List<FormeX>
) {
    constructor() : this(listOf())
}