package com.example.pokeapp.dto

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val en: String,
    val fr: String,
    val jp: String
) {
    constructor() : this("", "", "")
}