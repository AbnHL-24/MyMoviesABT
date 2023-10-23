package com.abn.mymoviesabt.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDBService {

    @GET("movies/popular")
    fun listPopularMovies(@Query("api_Key") apiKey: String): Call<MovieDBResult>
}