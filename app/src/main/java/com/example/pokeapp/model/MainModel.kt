package com.example.pokeapp.model

import androidx.lifecycle.ViewModel
import com.example.pokeapp.dao.PokemonDao
import com.example.pokeapp.database.PokemonDatabase
import com.example.pokeapp.dto.PokemonDto
import com.example.pokeapp.entities.Pokemon
import com.example.pokeapp.modelView.MainActivity
import com.example.pokeapp.service.PokemonService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainModel : ViewModel() {
     private val service = PokemonService.create()
        suspend fun getPokemonByName(pokemonName : String) = service.getPokemonByName(pokemonName)

        fun insertPokemonInLocal(pokemonDto: PokemonDto) {
            val pokemon = Pokemon()
            pokemon.pokemon_id = pokemonDto.pokedexId!!
            pokemon.name = pokemonDto.name?.fr!!
            pokemon.insertionTimestamp = System.currentTimeMillis()

            GlobalScope.launch {
                MainActivity.database.pokemonDao().insertPokemon(pokemon)
            }
        }


}
