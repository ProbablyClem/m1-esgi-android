package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val atk: Int,
    val def: Int,
    val hp: Int,
    val spe_atk: Int,
    val spe_def: Int,
    val vit: Int
) {
    constructor() : this(0, 0, 0, 0, 0, 0)
}