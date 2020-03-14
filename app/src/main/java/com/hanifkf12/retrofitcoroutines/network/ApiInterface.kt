package com.hanifkf12.moviecatalogsubmission3.network

import com.hanifkf12.moviecatalogsubmission3.model.movie.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/popular")
    fun getMovie(@Query("api_key") apiKey : String) : Deferred<Response<MovieResponse>>

}