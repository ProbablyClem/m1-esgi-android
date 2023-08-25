package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Sexe(
    val female: Double?,
    val male: Double?
) {
    constructor() : this(0.0, 0.0)
}