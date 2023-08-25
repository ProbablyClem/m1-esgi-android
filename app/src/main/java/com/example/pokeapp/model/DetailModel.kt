package com.example.pokeapp.model

import androidx.lifecycle.ViewModel
import com.example.pokeapp.R
import com.example.pokeapp.entities.Pokemon
import com.example.pokeapp.modelView.DetailActivity
import com.example.pokeapp.modelView.ListActivity
import com.example.pokeapp.modelView.MainActivity
import java.lang.Math.round

class DetailModel: ViewModel() {
    suspend fun getLastPokemon() : Pokemon {
        return MainActivity.database.pokemonDao().getLatestPokemon()!!
    }

    fun calculProgress(pv: Int):Int {
        return round((pv.toDouble()/255)*100).toInt()
    }

    fun getColorThemeByType(type: String, activity: DetailActivity): Int {
        val typeColor = when (type) {
            "Insecte" -> activity.getColor(R.color.Insecte)
            "Ténèbres" -> activity.getColor(R.color.Ténèbres)
            "Dragon" -> activity.getColor(R.color.Dragon)
            "Électrik" -> activity.getColor(R.color.Électrik)
            "Fée" -> activity.getColor(R.color.Fée)
            "Combat" -> activity.getColor(R.color.Combat)
            "Feu" -> activity.getColor(R.color.Feu)
            "Vol" -> activity.getColor(R.color.Vol)
            "Spectre" -> activity.getColor(R.color.Spectre)
            "Normal" -> activity.getColor(R.color.Normal)
            "Plante" -> activity.getColor(R.color.Plante)
            "Sol" -> activity.getColor(R.color.Sol)
            "Glace" -> activity.getColor(R.color.Glace)
            "Poison" -> activity.getColor(R.color.Poison)
            "Psy" -> activity.getColor(R.color.Psy)
            "Roche" -> activity.getColor(R.color.Roche)
            "Acier" -> activity.getColor(R.color.Acier)
            "Eau" -> activity.getColor(R.color.Eau)
            else -> activity.getColor(R.color.red)
        }
        return typeColor
    }
}