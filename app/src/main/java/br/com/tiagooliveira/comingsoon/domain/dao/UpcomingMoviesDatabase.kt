package br.com.tiagooliveira.comingsoon.domain.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie

/**
 * Class which will manage the database Room. This class defines a list with all entities which needs
 * to be persisted, name and version of the database
 */
@Database(entities = arrayOf(UpcomingMovie::class), version = 1)
abstract class UpcomingMoviesDatabase: RoomDatabase(){
    abstract fun upcomingMovieDAO(): UpcomingMovieDAO
}