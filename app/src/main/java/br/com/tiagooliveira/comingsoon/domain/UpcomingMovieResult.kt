package br.com.tiagooliveira.comingsoon.domain

import com.google.gson.annotations.SerializedName

data class UpcomingMovieResult(@SerializedName("results") val results : ArrayList<UpcomingMovie> = ArrayList())
