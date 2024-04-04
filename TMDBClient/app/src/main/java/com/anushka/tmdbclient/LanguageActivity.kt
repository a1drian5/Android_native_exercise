package com.anushka.tmdbclient

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anushka.tmdbclient.databinding.ActivityLanguageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Segun el boton presionado, es el idioma que se escogera

        binding.enButton1.setOnClickListener {
            setLanguageInSharedPreferences("en-Us")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.esButton2.setOnClickListener {
            setLanguageInSharedPreferences("es")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Guarda la preferencia del idioma
    private fun setLanguageInSharedPreferences(language: String) {
        val sharedPreferences = applicationContext.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("language", language)
        editor.apply()
    }
}