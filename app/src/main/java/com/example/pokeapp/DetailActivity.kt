package com.example.pokeapp


import android.content.Intent
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.databinding.ActivityDetailBinding
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var typePokemonColor by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        typePokemonColor = getColor(R.color.Poison)
        binding.container.setBackgroundColor(typePokemonColor)
        binding.arrowBack.setOnClickListener() {
            val intent = Intent(this, ListActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
        binding.typeComponent.setColorFilter(typePokemonColor)

        setContentView(binding.root)
    }
}

//@+id/description max size 100 characters