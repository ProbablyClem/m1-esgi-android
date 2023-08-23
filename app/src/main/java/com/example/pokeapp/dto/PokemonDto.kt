package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDto(
    val catch_rate: Int? = null,
    val category: String? = null,
    val egg_groups: List<String>? = null,
    val evolution: Evolution? = null,
    val forme: Forme? = null,
    val generation: Int? = null,
    val height: String? = null,
    val level_100: Int? = null,
    val name: Name? = null,
    val pokedexId: Int? = null,
    val resistances: List<Resistance>? = null,
    val sexe: Sexe? = null,
    val sprites: SpritesX? = null,
    val stats: Stats? = null,
    val talents: List<Talent>? = null,
    val types: List<Type>? = null,
    val weight: String? = null
) {
    constructor() : this(0, "", emptyList(), Evolution(), Forme(), 0, "", 0, Name(), 0, emptyList(), Sexe(), SpritesX(), Stats(), emptyList(), emptyList(), "")
}