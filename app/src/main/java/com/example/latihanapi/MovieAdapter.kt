package com.example.latihanapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanapi.databinding.ItemMoviesBinding
import com.example.latihanapi.model.Result

class MovieAdapter(var listMovie : List<Result>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(var binding: ItemMoviesBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.Judul.text = listMovie[position].originalTitle
        holder.binding.Tanggal.text = listMovie[position].releaseDate
        holder.binding.Rating.text = listMovie[position].voteAverage.toString()
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listMovie[position].posterPath}").into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}