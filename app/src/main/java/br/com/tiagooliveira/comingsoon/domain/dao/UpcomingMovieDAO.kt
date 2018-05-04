package br.com.tiagooliveira.comingsoon.domain.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie

/**
 * Class DAO which defines the operations
 */
@Dao
interface UpcomingMovieDAO{
    @Query("SELECT * FROM movie WHERE id = :arg0")
    fun getById(id: Long): UpcomingMovie?

    @Query("SELECT * FROM movie")
    fun findAll(): List<UpcomingMovie>

    @Insert
    fun insert(movie: UpcomingMovie)

    @Delete
    fun delete(movie: UpcomingMovie)
}