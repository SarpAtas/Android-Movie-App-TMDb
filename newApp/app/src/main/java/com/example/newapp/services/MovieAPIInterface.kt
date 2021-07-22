package com.example.newapp.services
import com.example.newapp.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPIInterface {
    @GET("/3/movie/popular?api_key=6b87b078648acd459928b3df4e0b005f")
    fun getMovieList(): Call<MovieResponse>

    @GET("/3/search/movie?api_key=6b87b078648acd459928b3df4e0b005f")
    fun searchMovieByName(
        @Query("query")  query: String
    ): Call<MovieResponse>



    @GET("3/movie/{movie_id}?api_key=6b87b078648acd459928b3df4e0b005f")
    fun getMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key")  api_key: String
    ): Call<MovieResponse>
}