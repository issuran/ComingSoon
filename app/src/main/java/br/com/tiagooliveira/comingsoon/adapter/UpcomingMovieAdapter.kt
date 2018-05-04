package br.com.tiagooliveira.comingsoon.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.activity.MovieDetailsActivity
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import br.com.tiagooliveira.comingsoon.utils.extensions.loadImage
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
import kotlinx.android.synthetic.main.adapter_upcoming_movie.view.*

class UpcomingMovieAdapter(
    val movies: ArrayList<UpcomingMovie>) : RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieAdapterHolder>(){

    // Viewholder with the views
    class UpcomingMovieAdapterHolder(view: View) : RecyclerView.ViewHolder(view)

    // Return qtd of movies in the list
    override fun getItemCount() = this.movies.size

    // Inflate adapter layout and return the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieAdapterHolder {
        // Inflate adapter view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_upcoming_movie, parent, false)

        // Return ViewHolder which contains all views
        val holder = UpcomingMovieAdapterHolder(view)
        return holder
    }

    // Bind to update view's values with the Movie values
    override fun onBindViewHolder(holder: UpcomingMovieAdapterHolder, position: Int) {
        val context = holder.itemView.context

        val view = holder.itemView

        with(view){
            // Get movie object
            val movie = movies[position]

            // Update movie's values
            tTitle.text = movie.title
            tReleaseDate.setText(context.getString(R.string.release_date, movie.releaseDate))
            progress.visibility = View.VISIBLE

            // Download the image and display ProgressBar
            imgUpcomingMovie.loadImage("${Constants.baseImageUrl}${movie.posterPath}")

            // Add click event in the line
            holder.itemView.setOnClickListener({
                _: View? -> run{
                val intent = Intent(context, MovieDetailsActivity::class.java)
                intent.putExtra(Constants.movie_identifier, movie.id)
                context.startActivity(intent)
            }
            })
        }
    }
}