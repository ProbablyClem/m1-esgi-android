package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Resistance(
    val multiplier: Double?,
    val name: String?
)