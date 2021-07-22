package com.example.newapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapp.databinding.ActivityMainBinding
import com.example.newapp.models.Movie
import com.example.newapp.models.MovieResponse
import com.example.newapp.services.MovieAPIInterface
import com.example.newapp.services.MovieAPIService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->rv_movies_list.adapter = MovieAdapter(movies,this)}
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("input",search.text.toString())
            startActivity(intent)
        }

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieAPIService.getInstance().create(MovieAPIInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}