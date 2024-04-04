package com.anushka.tmdbclient

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anushka.tmdbclient.databinding.ActivityMainBinding
import com.anushka.tmdbclient.presentation.movie.MovieActivity
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val PREFS_NAME = "MyPrefsFile"
    private val PREF_FIRST_LAUNCH = "isFirstLaunch"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean(PREF_FIRST_LAUNCH, true)

        if (isFirstLaunch) {
            // La aplicación se está ejecutando por primera vez, muestra la actividad
            val intent = Intent(this, LanguageActivity::class.java)
            startActivity(intent)

            // Establece la bandera de primera ejecución a false
            val editor = sharedPreferences.edit()
            editor.putBoolean(PREF_FIRST_LAUNCH, false)
            editor.apply()
        }

        binding.popularButton1.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.ratedButton2.setOnClickListener {
            val intent = Intent(this, TopRateMovieActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Evita volver atrás con gestos
        window.decorView.setOnTouchListener { _, _ -> true }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // No hagas nada para ignorar el evento de retroceso
        finish()
    }
}
