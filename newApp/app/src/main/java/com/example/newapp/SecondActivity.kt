package com.example.newapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapp.models.Movie
import com.example.newapp.models.MovieResponse
import com.example.newapp.services.MovieAPIInterface
import com.example.newapp.services.MovieAPIService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.button
import kotlinx.android.synthetic.main.activity_second.rv_movies_list
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val input=intent.getStringExtra("input")
        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        textInSearchPage.text= "Searching: " + input

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData(input) { movies : List<Movie> ->rv_movies_list.adapter = MovieAdapter(movies , this)}
    }
    private fun getMovieData( input:String? , callback: (List<Movie>) -> Unit ){
        val apiService = MovieAPIService.getInstance().create(MovieAPIInterface::class.java)
        apiService.searchMovieByName(input!!).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }
}