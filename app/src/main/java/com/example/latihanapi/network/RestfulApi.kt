package com.example.latihanapi.network

import com.example.latihanapi.model.Movie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<Movie<com.example.latihanapi.model.Result>>
}