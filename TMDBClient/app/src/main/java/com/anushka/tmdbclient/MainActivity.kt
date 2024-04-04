package com.anushka.tmdbclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anushka.tmdbclient.databinding.ActivityMainBinding
import com.anushka.tmdbclient.presentation.movie.MovieActivity
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.popularButton1.setOnClickListener {
            setLanguageInSharedPreferences("en-Us")
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.ratedButton2.setOnClickListener {
            setLanguageInSharedPreferences("es")
            val intent = Intent(this, TopRateMovieActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setLanguageInSharedPreferences(language: String) {
        val sharedPreferences = applicationContext.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("language", language)
        editor.apply()
    }
}