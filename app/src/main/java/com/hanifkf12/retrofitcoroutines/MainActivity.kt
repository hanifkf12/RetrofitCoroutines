package com.hanifkf12.retrofitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hanifkf12.retrofitcoroutines.repository.MovieRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object{
        var TAG = MainActivity::class.java.simpleName
    }
    private lateinit var repository: MovieRepository
    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository = MovieRepository()
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.fetchMovies()
        viewModel.data.observe(this, Observer {
            textV.text = it
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelAllRequests()
    }
}
