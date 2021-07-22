package com.example.newapp.models

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class MovieResponse(
    @SerializedName ("results")
    val movies : List<Movie>
) : Parcelable{
    constructor(): this(mutableListOf())
}