package com.hanifkf12.retrofitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanifkf12.moviecatalogsubmission3.model.movie.Movie
import com.hanifkf12.retrofitcoroutines.adapter.MovieAdapter
import com.hanifkf12.retrofitcoroutines.databinding.ActivityMainBinding
import com.hanifkf12.retrofitcoroutines.repository.MovieRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object{
        var TAG = MainActivity::class.java.simpleName
    }
    private lateinit var viewModel: MovieViewModel
    private var listMovie: MutableList<Movie> = mutableListOf()
    private lateinit var adapter : MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        binding.main = viewModel
        adapter = MovieAdapter(this, listMovie){
            Toast.makeText(this,it.title,Toast.LENGTH_SHORT).show()
        }
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.adapter = adapter
        viewModel.fetchMovies()
        viewModel.loading.observe(this, Observer {
            progressBar.visibility = if(it) View.VISIBLE else View.GONE
        })

        viewModel.data.observe(this, Observer {
            it?.let {
                listMovie.clear()
                listMovie.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

    }

}
