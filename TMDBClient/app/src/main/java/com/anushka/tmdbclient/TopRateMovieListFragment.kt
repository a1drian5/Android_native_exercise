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
import com.anushka.tmdbclient.databinding.FragmentTopRateMovieListBinding
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieAdapter
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieViewModel
import com.anushka.tmdbclient.presentation.topRateMovie.TopRateMovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class TopRateMovieListFragment : Fragment() {

    @Inject
    lateinit var factory: TopRateMovieViewModelFactory
    private lateinit var topRateMovieViewModel: TopRateMovieViewModel
    private lateinit var binding: FragmentTopRateMovieListBinding
    private lateinit var adapter: TopRateMovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopRateMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRateMovieViewModel = ViewModelProvider(this, factory)
            .get(TopRateMovieViewModel::class.java)
        val responseLiveData = topRateMovieViewModel.getTopRateMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("MYTAG", it.toString())
        })
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = GridLayoutManager(context,2)
        // Obtener NavController
        val navController = findNavController()
        adapter = TopRateMovieAdapter(navController)
        binding.movieRecyclerView.adapter = adapter
        displayTopRateMovies()
    }

    private fun displayTopRateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = topRateMovieViewModel.getTopRateMovies()
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