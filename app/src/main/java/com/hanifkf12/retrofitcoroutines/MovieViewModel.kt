package com.hanifkf12.retrofitcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanifkf12.retrofitcoroutines.repository.MovieRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieViewModel : ViewModel(){

    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)
    val data : MutableLiveData<String> = MutableLiveData()
    private val repository = MovieRepository()

    fun fetchMovies(){
        scope.launch {
           repository.getMovie {
               data.value = it.totalResults.toString()
           }
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()
}