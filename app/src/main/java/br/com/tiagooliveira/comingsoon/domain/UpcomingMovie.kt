package br.com.tiagooliveira.comingsoon.domain

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class UpcomingMovie(@PrimaryKey @SerializedName("id") val id : Int = 0,
                         @SerializedName("title") val title : String,
                         @SerializedName("original_language") val titleOriginalLanguage : String,
                         @SerializedName("release_date") val releaseDate: String,
                         @SerializedName("poster_path") val posterPath: String?,
                         @SerializedName("backdrop_path") val backdropPath: String?)