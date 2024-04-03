package com.anushka.tmdbclient

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.anushka.tmdbclient.databinding.FragmentMovieListBinding
import com.anushka.tmdbclient.presentation.movie.MovieAdapter
import com.anushka.tmdbclient.presentation.movie.MovieViewModel
import com.anushka.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MovieListFragment : Fragment() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: FragmentMovieListBinding
    private lateinit var adapter: MovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel = ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("MYTAG", it.toString())
        })
        initRecyclerView()
        displayPopularMovies()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = GridLayoutManager(context,2)
        // Obtener NavController
        val navController = findNavController()
        adapter = MovieAdapter(navController)
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}