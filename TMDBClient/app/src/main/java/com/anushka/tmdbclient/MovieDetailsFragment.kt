package com.anushka.tmdbclient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anushka.tmdbclient.databinding.FragmentMovieDetailsBinding
import com.bumptech.glide.Glide

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private var movieId: Int = 0
    private var movieTitle: String? = "N/A"
    private var movieOverview: String? = "N/A"
    private var movieReleaseDate: String? = "N/A"
    private var movieVoteAverage: String? = "N/A"
    private var moviePosterPath: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtiene los datos del anterior fragmento
        arguments?.let {
            movieId = it.getInt("movieId")
            movieOverview = it.getString("movieOverview")
            movieTitle = it.getString("movieTitle")
            movieReleaseDate = it.getString("movieReleaseDate")
            movieVoteAverage = it.getString("movieVoteAverage")
            moviePosterPath = it.getString("moviePosterPath")
        }

        // Ahora puedes usar los argumentos en tu lógica de fragmento
        binding.textViewTitle.text = movieTitle
        binding.textViewRating.text = movieVoteAverage
        binding.textViewSynopsis.text = movieOverview
        binding.textViewReleaseDate.text = movieReleaseDate
        // La imagen se carga diferente a los otros parametros
        val posterURL = "https://image.tmdb.org/t/p/w185$moviePosterPath"
        Glide.with(binding.imageViewPoster.context)
            .load(posterURL)
            .into(binding.imageViewPoster)
    }

}