package com.abn.mymoviesabt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abn.mymoviesabt.databinding.ViewMovieItemBinding
import com.bumptech.glide.Glide

class MoviesAdapter(
    private val movies: List<Movie>,
    private val movieClickedListener: (Movie) -> Unit
):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {movieClickedListener(movie)}
    }

    override fun getItemCount() = movies.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)

    }

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie){
            binding.Title.text = movie.title
            Glide
                .with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)
        }
    }
}