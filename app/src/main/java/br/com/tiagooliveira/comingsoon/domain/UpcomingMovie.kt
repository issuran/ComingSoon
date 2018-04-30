package br.com.tiagooliveira.comingsoon.domain

import com.google.gson.annotations.SerializedName

data class UpcomingMovie(@SerializedName("id") val id : Int = 0,
                         @SerializedName("title") val title : String,
                         @SerializedName("original_language") val titleOriginalLanguage : String,
                         @SerializedName("release_date") val releaseDate: String,
                         @SerializedName("poster_path") val posterPath: String?,
                         @SerializedName("backdrop_path") val backdropPath: String?)