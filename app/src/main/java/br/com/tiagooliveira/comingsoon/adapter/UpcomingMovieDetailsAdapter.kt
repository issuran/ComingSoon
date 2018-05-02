package br.com.tiagooliveira.comingsoon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.tiagooliveira.comingsoon.R
import br.com.tiagooliveira.comingsoon.domain.UpcomingMovieGenres

class UpcomingMovieDetailsAdapter(val context: Context, val dataSource: ArrayList<UpcomingMovieGenres>) : BaseAdapter() {

    val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.adapter_genrer_row, parent, false)

        val title = rowView.findViewById<TextView>(R.id.tGenrer)

        val imgGenrer = rowView.findViewById<ImageView>(R.id.imgGenrer)

        val genrer = getItem(position) as UpcomingMovieGenres

        getImgGenrer(genrer.id).let{
            imgGenrer.setImageResource(it!!)
        }

        title.text = genrer.gender


        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    fun getImgGenrer(id: Int): Int?{

            when(id){
                28 -> return R.drawable.ic_action
                12 -> return R.drawable.ic_adventure
                16 -> return R.drawable.ic_animation
                35 -> return R.drawable.ic_comedy
                80 -> return R.drawable.ic_crime
                99 -> return R.drawable.ic_documentary
                18 -> return R.drawable.ic_drama
                10751 -> return R.drawable.ic_family
                14 -> return R.drawable.ic_fantasy
                27 -> return R.drawable.ic_horror
                10402 -> return R.drawable.ic_music
                9648 -> return R.drawable.ic_mistery
                10749 -> return R.drawable.ic_romance
                878 -> return R.drawable.ic_fiction
                10770 -> return R.drawable.ic_tv_movie
                53 -> return R.drawable.ic_triller
                10752 -> return R.drawable.ic_war
                37 -> return R.drawable.ic_western
            }
        return null
    }
}