package br.com.tiagooliveira.comingsoon.domain

import com.google.gson.annotations.SerializedName

data class UpcomingMovieDetail( @SerializedName("id") val id : Int = 0,
                                @SerializedName("genres") val genres : ArrayList<UpcomingMovieGenres> = ArrayList(),
                                @SerializedName("original_language") val originalLanguage : String,
                                @SerializedName("release_date") val releaseDate: String,
                                @SerializedName("overview") val overview: String?,
                                @SerializedName("runtime") val runtime: String?,
                                @SerializedName("vote_average") val voteAverage: Double,
                                @SerializedName("popularity") val popularity: Double,
                                @SerializedName("poster_path") val posterPath: String?,
                                @SerializedName("video") val trailer: Boolean,
                                @SerializedName("backdrop_path") val backdropPath: String?)