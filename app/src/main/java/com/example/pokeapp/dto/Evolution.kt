package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Evolution(
    val mega: List<Mega>?,
    val next: List<Next>?,
    val pre: List<Pre>?,
) {
    constructor() : this(listOf(), listOf(), listOf())
}