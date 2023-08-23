package com.example.pokeapp.model

import androidx.lifecycle.ViewModel
import com.example.pokeapp.entities.Pokemon
import com.example.pokeapp.modelView.MainActivity

class DetailModel: ViewModel() {
    suspend fun getLastPokemon() : Pokemon {
        return MainActivity.database.pokemonDao().getLatestPokemon()!!
    }
}