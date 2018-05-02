package br.com.tiagooliveira.comingsoon.adapter

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.activity.MovieDetailsActivity
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovie
import br.com.tiagooliveira.comingsoon.utils.constants.Constants
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class UpcomingMovieAdapter(
    val movies: ArrayList<UpcomingMovie>) : RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieAdapterHolder>(){

    // Viewholder with the views
    class UpcomingMovieAdapterHolder(view: View) : RecyclerView.ViewHolder(view){
        var tTitle: TextView
        var tReleaseDate: TextView
        var imgMovieImage: ImageView
        var progress: ProgressBar
        var cardView: CardView
        init {
            // Save views in the Holder
            tTitle = view.findViewById(R.id.tTitle)
            tReleaseDate = view.findViewById(R.id.tReleaseDate)
            imgMovieImage = view.findViewById(R.id.imgUpcomingMovie)
            progress = view.findViewById(R.id.progress)
            cardView = view.findViewById(R.id.movieCardView)
        }
    }

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

        // Get movie object
        val movie = movies[position]

        // Update movie's values
        holder.tTitle.text = movie.title
        holder.tReleaseDate.setText(context.getString(R.string.release_date, movie.releaseDate))
        holder.progress.visibility = View.VISIBLE

        // Download the image and display ProgressBar
        Picasso.get()
                .load(Constants.baseImageUrl + movie.posterPath)
                .placeholder(R.drawable.placeholder_movie)
                .error(R.drawable.placeholder_movie)
                .into(holder.imgMovieImage, object : Callback{
                    override fun onSuccess() {
                        // Download OK
                        holder.progress.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        holder.progress.visibility = View.GONE
                    }
                })

        // Add click event in the line
        holder.itemView.setOnClickListener(View.OnClickListener {
            _: View? -> run{
            var intent : Intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(Constants.movie_identifier, movie.id)
            context.startActivity(intent)
            }
        })
    }
}