package br.com.tiagooliveira.comingsoon

import android.app.Application

class UpcomingMovieApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        // Singleton
        private var appInstance: UpcomingMovieApplication? = null
        fun getInstance(): UpcomingMovieApplication{
            if(appInstance == null){
                throw IllegalStateException("@string/application_error")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}