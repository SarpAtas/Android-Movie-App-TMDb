package com.example.newapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.newapp.models.Movie
import com.example.newapp.models.MovieResponse
import com.example.newapp.services.MovieAPIInterface
import com.example.newapp.services.MovieAPIService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.*

import kotlinx.android.synthetic.main.activity_second.button
import kotlinx.android.synthetic.main.activity_second.rv_movies_list
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.movie_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        imageButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val id=intent.getStringExtra("id")
        val img=intent.getStringExtra("img")
        val desc=intent.getStringExtra("desc")
        val release=intent.getStringExtra("release")
        var conv: Int? = id?.toInt()

        val title=intent.getStringExtra("title")
        titleMovie2.text = title
        Picasso.with(this).load(IMAGE_BASE + img).into(poster2)

        if(desc  ==  "")
            description2.text = "No Description Given"
        else
            description2.text = "Description: \n" + desc
        release_date2.text = "Release Date: " + release
        val key:String ="6b87b078648acd459928b3df4e0b005f"
    }
}