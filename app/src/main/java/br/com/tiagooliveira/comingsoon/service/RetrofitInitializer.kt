package br.com.tiagooliveira.comingsoon.service

import android.provider.SyncStateContract
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieDetail
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieResult
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val upcomingMovierApiService: UpcomingMoviesApiService

    init {
        val retrofit =  Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        upcomingMovierApiService = retrofit.create(UpcomingMoviesApiService::class.java)
    }

    fun getUpcomingMovies(sortBy: String?) : Call<UpcomingMovieResult> {
        if(!sortBy.isNullOrEmpty())
            return upcomingMovierApiService.getUpcomingMovies(sortBy!!)
        else
            return upcomingMovierApiService.getUpcomingMovies()
    }

    fun getUpcomingMovieDetails(id: Int) : Call<UpcomingMovieDetail>{
        return upcomingMovierApiService.getUpcomingMovieDetails(id)
    }
}