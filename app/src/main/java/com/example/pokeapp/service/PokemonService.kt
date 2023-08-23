package com.example.pokeapp.service

import com.example.pokeapp.dto.PokemonDto
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.jackson.*
import io.ktor.serialization.kotlinx.json.json


interface PokemonService {
    suspend fun getPokemonByName(pokemonName : String): PokemonDto

    companion object {
        fun create(): PokemonService {
            return PokemonServiceImpl(
                client = HttpClient(Android) {
                    install(ContentNegotiation) {
                        json(
                            json = kotlinx.serialization.json.Json {
                                ignoreUnknownKeys = true
                            }
                        )
                    }
                }
            )
        }
    }
}