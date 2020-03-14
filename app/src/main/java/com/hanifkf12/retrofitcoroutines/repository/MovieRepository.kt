package com.hanifkf12.retrofitcoroutines.repository

import com.hanifkf12.moviecatalogsubmission3.model.movie.MovieResponse
import com.hanifkf12.moviecatalogsubmission3.network.ApiResource
import com.hanifkf12.retrofitcoroutines.BuildConfig

class MovieRepository {
    companion object {
        const val apiKey = BuildConfig.TMDB_API_KEY
    }

    suspend fun getMovie(onResult: (MovieResponse) -> Unit, onError : (String)->Unit)  {

        val response = ApiResource.create().getMovieAsync(apiKey).await()
        if(response.isSuccessful){
            response.body()?.let {
                onResult(it)
            }
        }else{
            onError(response.message())
        }


    }
}