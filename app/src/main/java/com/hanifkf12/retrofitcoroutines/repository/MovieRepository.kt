package com.hanifkf12.retrofitcoroutines.repository

import com.hanifkf12.moviecatalogsubmission3.model.movie.MovieResponse
import com.hanifkf12.moviecatalogsubmission3.network.ApiResource
import com.hanifkf12.retrofitcoroutines.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MovieRepository {
    companion object {
        const val apiKey = BuildConfig.TMDB_API_KEY
    }

    suspend fun getMovie(onResult: (MovieResponse) -> Unit)  {

        val response = ApiResource.create().getMovie(apiKey).await()
        response.body()?.let {
            onResult(it)
        }

    }
}