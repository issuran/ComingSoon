package br.com.tiagooliveira.comingsoon.utils.extensions

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.AppCompatImageView
import br.com.tiagooliveira.comingsoon.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Method to load image into ImageView using picasso
 */
fun AppCompatImageView.loadImage(url: String?) {
    if (url != null && url.isNotBlank()) {
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.placeholder_load)
                .error(R.drawable.placeholder_no_poster)
                .into(this)
    } else {
        Picasso.get().load(R.drawable.placeholder_load)
    }
}