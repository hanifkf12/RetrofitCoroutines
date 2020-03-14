package com.hanifkf12.retrofitcoroutines

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanifkf12.moviecatalogsubmission3.model.movie.Movie
import com.hanifkf12.retrofitcoroutines.repository.MovieRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieViewModel : ViewModel(){
    private val repository = MovieRepository()

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    val data : MutableLiveData<List<Movie>> = MutableLiveData()
    val loading : MutableLiveData<Boolean> = MutableLiveData()

    fun fetchMovies(){
        loading.value = true
        Log.d("Fecth","LOAD MOVIE")
        scope.launch {
           repository.getMovie({
               data.value = it.results
               loading.value = false
           },{
               loading.value = false
               Log.d("ERR", it)
           })
        }
    }

}