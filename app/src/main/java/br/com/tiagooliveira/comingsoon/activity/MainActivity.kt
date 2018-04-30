package br.com.tiagooliveira.comingsoon.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieDetail
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieResult
import br.com.tiagooliveira.comingsoon.service.RetrofitInitializer
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        
    }


}