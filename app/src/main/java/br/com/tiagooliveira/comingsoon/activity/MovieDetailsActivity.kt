package br.com.tiagooliveira.comingsoon.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.adapter.UpcomingMovieDetailsAdapter
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieDetail
import br.com.tiagooliveira.comingsoon.service.RetrofitInitializer
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_details_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var mContext : Context


    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.movie_details_activity)

        mContext = this

        var movieId = 0

        var bundle = intent.extras
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

                    listView = findViewById<ListView>(R.id.listViewGenrer)

                    val adapter = UpcomingMovieDetailsAdapter(mContext, upcomingMovie.genres)
                    listView.adapter = adapter

                    var title = findViewById<TextView>(R.id.tTitleDetail)
                    var release = findViewById<TextView>(R.id.tReleaseDateDetail)
                    var img = findViewById<ImageView>(R.id.imgMovieDetails)
                    var description = findViewById<TextView>(R.id.tMovieDescription)
                    var duration = findViewById<TextView>(R.id.tMovieDuration)


                    toolbar_layout.title = upcomingMovie.originalTitle
                    title.text = upcomingMovie.originalTitle
                    release.text = upcomingMovie.releaseDate
                    description.text = upcomingMovie.overview
                    duration.setText(mContext.getString(R.string.duration_time, upcomingMovie.runtime.toString()))

                    // Download the image and display ProgressBar
                    Picasso.get()
                            .load(Constants.baseImageUrl + upcomingMovie.posterPath)
                            .placeholder(R.drawable.placeholder_movie)
                            .error(R.drawable.placeholder_movie)
                            .into(img, object : com.squareup.picasso.Callback {
                                override fun onSuccess() {
                                }

                                override fun onError(e: Exception?) {
                                }
                            })
                }
            }

        })
    }
}