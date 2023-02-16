package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Model.Movie
import com.example.myapplication.databinding.AdapterMovieBinding

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}
class MainAdaptor : RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movie>()

    fun setMovieList(movies : List<Movie>){
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name

        Glide.with(holder.itemView.context).load(movie.imageUrl)
            .into(holder.binding.imageview)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}