package br.com.tiagooliveira.comingsoon.service

import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieDetail
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieResult
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UpcomingMoviesApiService{

    @GET("/3/movie/upcoming")
    fun getUpcomingMovies(@Query("sort_by") sort_by: String = Constants.sortByReleaseDate,
                          @Query("api_key") apikey: String = Constants.apiKey
                          )
            : Call<UpcomingMovieResult>

    @GET("/3/movie/{id}")
    fun getUpcomingMovieDetails(@Path("id")heroId: Int,
                       @Query("api_key") apikey: String = Constants.apiKey)
            : Call<UpcomingMovieDetail>

}