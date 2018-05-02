package br.com.tiagooliveira.comingsoon.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.adapter.UpcomingMovieAdapter
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieResult
import br.com.tiagooliveira.comingsoon.service.RetrofitInitializer
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity(){

    var recyclerView: RecyclerView? = null
    var linearLayoutManager:LinearLayoutManager? = null
    var currentPage:Int = 1
    val arrayUpcomingMovies: ArrayList<UpcomingMovie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        // grid layout manager
        val mLayoutManager = GridLayoutManager(this, 2)

        recyclerView = findViewById(R.id.recyclerView)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = mLayoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.setHasFixedSize(true)

        taskMovies(currentPage)
    }
    
    fun taskMovies(page: Int){

        // Retrieve movies and Update list
        val call = RetrofitInitializer().getUpcomingMovies(page, Constants.sortByReleaseDate)
        call.enqueue(object : Callback<UpcomingMovieResult> {
            override fun onFailure(call: Call<UpcomingMovieResult>?, t: Throwable?) {
                Log.d("RETROFIT","Error : " + t.toString())
            }

            override fun onResponse(call: Call<UpcomingMovieResult>?, response: Response<UpcomingMovieResult>?) {
                response?.let {
                    val upcomingMovies = it.body()

                    if(upcomingMovies != null && upcomingMovies.results.size > 0){
                        arrayUpcomingMovies.addAll(upcomingMovies.results)
                        recyclerView?.adapter = UpcomingMovieAdapter(arrayUpcomingMovies!!)
                    }
                }
            }

        })
    }

}