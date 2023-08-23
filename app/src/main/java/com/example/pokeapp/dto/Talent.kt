package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Talent(
    val name: String,
    val tc: Boolean
)