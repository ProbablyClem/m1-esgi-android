package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Forme(
    val forme: FormeX? = null
) {
    constructor() : this(FormeX(null, null))
}