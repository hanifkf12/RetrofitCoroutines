package com.hanifkf12.retrofitcoroutines.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanifkf12.moviecatalogsubmission3.model.movie.Movie
import com.hanifkf12.retrofitcoroutines.ItemMovieViewModel
import com.hanifkf12.retrofitcoroutines.R
import com.hanifkf12.retrofitcoroutines.databinding.ItemMovieBinding
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter (private val context: Context?, private val list: List<Movie>, private val listener : (Movie)->Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_movie,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(list[position], listener)
    }

    class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(movie: Movie, listener: (Movie) -> Unit){
            val itemMovieViewModel = ItemMovieViewModel(movie)
            binding.itemMovie = itemMovieViewModel
            binding.ivPoster.setOnClickListener {
                listener(movie)
            }
        }
    }

}