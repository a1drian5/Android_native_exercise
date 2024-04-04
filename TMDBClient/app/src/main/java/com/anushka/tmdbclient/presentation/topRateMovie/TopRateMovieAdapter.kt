package com.anushka.tmdbclient.presentation.topRateMovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.anushka.tmdbclient.R
import com.anushka.tmdbclient.TopRateMovieListFragmentDirections
import com.anushka.tmdbclient.data.model.movie.TopRateMovie
import com.anushka.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TopRateMovieAdapter(private val navController: NavController): RecyclerView.Adapter<MyViewHolder>() {
    private val topRateMovieList = ArrayList<TopRateMovie>()

    fun setList(topRateMovies:List<TopRateMovie>){
        topRateMovieList.clear()
        topRateMovieList.addAll(topRateMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return topRateMovieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topRateMovie = topRateMovieList[position]
        holder.bind(topRateMovie)
        holder.binding.imageView.setOnClickListener {
            val action = TopRateMovieListFragmentDirections.actionTopRateMovieListFragmentToTopRateMovieDetailsFragment(
                movieId = topRateMovie.id,
                movieOverview = topRateMovie.overview,
                movieTitle = topRateMovie.title,
                movieReleaseDate = topRateMovie.releaseDate,
                movieVoteAverage = topRateMovie.voteAverage,
                moviePosterPath = topRateMovie.posterPath
            )
            navController.navigate(action)
        }

    }
}



class MyViewHolder(val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(topRateMovie: TopRateMovie){
        val posterURL = "https://image.tmdb.org/t/p/w185"+ topRateMovie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }
}