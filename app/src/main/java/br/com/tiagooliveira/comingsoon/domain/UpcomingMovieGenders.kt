package br.com.tiagooliveira.comingsoon.domain

import com.google.gson.annotations.SerializedName

data class UpcomingMovieGenders(@SerializedName("id") val id : Int = 0,
                                 @SerializedName("name") val gender : String)