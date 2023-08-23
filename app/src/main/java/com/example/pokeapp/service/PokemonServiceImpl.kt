package com.example.pokeapp.service

import com.example.pokeapp.dto.PokemonDto
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.*

class PokemonServiceImpl(
    private val client: HttpClient
) : PokemonService {
    override suspend fun getPokemonByName(pokemonName: String): PokemonDto{
        return try {
            client.get {
                url(HttpRoutes.BASE_URL + pokemonName)
            }.body()
        }catch (e : RedirectResponseException){
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            PokemonDto()
        }catch (e : ClientRequestException){
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            PokemonDto()
        }catch (e : ServerResponseException){
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            PokemonDto()
        }
    }
}