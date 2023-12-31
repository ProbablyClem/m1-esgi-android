package com.example.pokeapp.modelView


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.pokeapp.database.PokemonDatabase
import com.example.pokeapp.databinding.ActivityMainBinding
import com.example.pokeapp.dto.PokemonDto
import com.example.pokeapp.model.DetailModel
import com.example.pokeapp.model.MainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var database: PokemonDatabase
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //initialize the localdatabase
        database = Room.databaseBuilder(applicationContext, PokemonDatabase::class.java, "pokemon_db")
            .fallbackToDestructiveMigration()
            .build()
        binding.searchBar.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Log.d("TheResearch", binding.searchBar.text.toString());
                search(binding.searchBar.text.toString())
                return@OnKeyListener true
            }
            false
        })
        binding.searchButton.setOnClickListener {
            Log.d("TheResearch", binding.searchBar.text.toString());
            search(binding.searchBar.text.toString());
        }

        setContentView(binding.root)

    }

    fun search(name: String) {

        GlobalScope.launch {
            model = MainModel()
            val result = model.getPokemonByName(name)
            withContext(Dispatchers.Main) {
                if (result.pokedexId == null) {
                    // No pokedexId data found, show an alert dialog
                    showPokemonNotFoundDialog()
                } else {
                    model.insertPokemonInLocal(result)
                    //Update the UI with the result of the API call -
                    Log.d("API Response in english", result.pokedexId.toString())
                    result.name?.let { Log.d("This is the french name", it.fr) }
                    result.evolution?.next?.get(0)
                        ?.let { it.name?.let { it1 -> Log.d("This is the next evolution", it1) } }
                    goNextPage()
                }
            }
        }

    }

    private fun showPokemonNotFoundDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Pokemon Not Found")
            .setMessage("The Pokémon you are searching for does not exist.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }

    private fun goNextPage(){
        val intent = Intent(this, ListActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}