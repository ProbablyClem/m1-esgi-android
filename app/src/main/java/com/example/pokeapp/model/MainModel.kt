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
            pokemon.type = pokemonDto.types?.get(0)?.name!!
            pokemon.weight = pokemonDto.weight!!
            pokemon.height = pokemonDto.height!!
            pokemon.capacity = pokemonDto.talents?.get(0)?.name!!
            pokemon.description = pokemonDto.category!!
            pokemon.image = pokemonDto.sprites?.regular!!
            pokemon.pv = pokemonDto.stats?.hp!!
            pokemon.attack = pokemonDto.stats?.atk!!
            pokemon.defense = pokemonDto.stats?.def!!
            pokemon.attackSpe = pokemonDto.stats?.spe_atk!!
            pokemon.defenseSpe = pokemonDto.stats?.spe_def!!
            pokemon.speed = pokemonDto.stats?.vit!!
            pokemon.insertionTimestamp = System.currentTimeMillis()

            GlobalScope.launch {
                MainActivity.database.pokemonDao().insertPokemon(pokemon)
            }
        }


}
