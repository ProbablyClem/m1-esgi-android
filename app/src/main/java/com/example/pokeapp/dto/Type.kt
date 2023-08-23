package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Type(
    val image: String,
    val name: String
)