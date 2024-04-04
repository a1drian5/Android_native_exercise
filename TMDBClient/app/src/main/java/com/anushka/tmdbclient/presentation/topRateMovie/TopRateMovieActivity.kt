package com.anushka.tmdbclient.presentation.topRateMovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.databinding.ActivityTopRateMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRateMovieActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityTopRateMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopRateMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() // Oculta la ActionBar proporcionada por AppCompat
        setSupportActionBar(binding.toolbar) // Configura la Toolbar como ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Muestra el botón de retroceso

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.topRateNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}