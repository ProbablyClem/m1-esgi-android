package com.example.pokeapp.modelView

import PokemonAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.databinding.ActivityListBinding
import com.example.pokeapp.entities.Pokemon
import com.example.pokeapp.model.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.pokeapp.database.PokemonDatabase

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var model: ListModel
    companion object {
        lateinit var database: PokemonDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        var myList : MutableList<Pokemon> = mutableListOf()
        val adapter = PokemonAdapter { clickedPokemon ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("pokemon_id", clickedPokemon.pokemon_id)
            startActivity(intent)
        }
        lifecycleScope.launch(Dispatchers.Main) {
            model = ListModel()
            val result = withContext(Dispatchers.IO) {
                model.getLastPokemon()
            }
            myList = mutableListOf(result)

            if (adapter != null) {
                adapter.submitList(myList)
            }
        }
        binding.arrowBack.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            adapter.currentList.clear()
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }

        val recyclerView = binding.recyclerView

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        setContentView(binding.root)
    }
}