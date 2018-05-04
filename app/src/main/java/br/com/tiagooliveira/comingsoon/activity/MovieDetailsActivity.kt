package br.com.tiagooliveira.comingsoon.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ListView
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.adapter.UpcomingMovieDetailsAdapter
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieDetail
import br.com.tiagooliveira.comingsoon.service.RetrofitInitializer
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import br.com.tiagooliveira.comingsoon.utils.extensions.loadImage
import kotlinx.android.synthetic.main.content_movie_details.*
import kotlinx.android.synthetic.main.movie_details_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var mContext : Context

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.movie_details_activity)

        mContext = this

        var movieId = 0

        val bundle = intent.extras
        if(bundle != null)
            movieId = bundle.getInt(Constants.movie_identifier)

        setSupportActionBar(toolbar)

        fillDetails(movieId)
    }

    fun fillDetails(movieId: Int){
        val call = RetrofitInitializer().getUpcomingMovieDetails(movieId)
        call.enqueue(object: Callback<UpcomingMovieDetail> {
            override fun onFailure(call: Call<UpcomingMovieDetail>?, t: Throwable?) {
                Log.d("RETROFIT","Error : " + t.toString())
            }

            override fun onResponse(call: Call<UpcomingMovieDetail>?, response: Response<UpcomingMovieDetail>?) {
                response?.let {
                    val upcomingMovie = it.body() as UpcomingMovieDetail

                    val adapter = UpcomingMovieDetailsAdapter(mContext, upcomingMovie.genres)
                    listViewGenre.adapter = adapter

                    toolbar_layout.title = upcomingMovie.originalTitle
                    tTitleDetail.text = upcomingMovie.originalTitle
                    tReleaseDateDetail.text = upcomingMovie.releaseDate
                    tMovieDescription.text = upcomingMovie.overview
                    tMovieDuration.setText(mContext.getString(R.string.duration_time, upcomingMovie.runtime.toString()))

                    // Download the image and display ProgressBar
                    imgMovieDetails.loadImage("${Constants.baseImageUrl}${upcomingMovie.posterPath}")
                }
            }

        })
    }
}