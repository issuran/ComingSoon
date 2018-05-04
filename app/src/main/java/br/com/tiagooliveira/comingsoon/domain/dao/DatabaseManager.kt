package br.com.tiagooliveira.comingsoon.domain.dao

import android.arch.persistence.room.Room
import br.com.tiagooliveira.comingsoon.UpcomingMovieApplication
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie

/**
 * Following Google documentation, it recommends to create a singleton of the class Database
 * (UpcomingMoviesDatabase), so to do this handle we use this class
 */
object DatabaseManager{
    // Room Singleton
    private var dbInstance: UpcomingMoviesDatabase
    init {
        val appContext = UpcomingMovieApplication.getInstance().applicationContext
        //Config Room
        dbInstance = Room.databaseBuilder(
                appContext,                             //Global context
                UpcomingMoviesDatabase::class.java,     //Application class reference
                "comingsoon.sqlite"               //Database file's name
        ).build()
    }

    fun getUpcomingMovieDAO(): UpcomingMovieDAO{
        return dbInstance.upcomingMovieDAO()
    }
}