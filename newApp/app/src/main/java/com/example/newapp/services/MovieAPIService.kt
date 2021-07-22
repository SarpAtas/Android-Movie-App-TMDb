package com.example.newapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.io.print as print1

class MovieAPIService {

    companion object{
        private const val base_URL = "https://api.themoviedb.org"
        private var retrofit: Retrofit?=null

        fun getInstance(): Retrofit{
            if(retrofit == null)
            {
                retrofit = Retrofit.Builder().baseUrl(base_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!
        }
    }
}