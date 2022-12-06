package com.example.egfwd_secound_project.ui.bindingAdaptor

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.egfwd_secound_project.R
import com.example.egfwd_secound_project.ui.model.Asteroid
import com.example.egfwd_secound_project.ui.model.PictureOfDay
import com.example.egfwd_secound_project.ui.rv.AsteroidAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:LoadPicFromUrl")
fun ImageView.pictureOfDay(src:PictureOfDay?) {
    if (src != null && src.url.isNotBlank()) {
        Picasso.get()
            .load(src.url)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_help_circle)
            .into(this)
    }
}
@BindingAdapter("app:statusIcon")
fun ImageView.bindAsteroidStatusImage( isHazardous: Boolean) {
    if (isHazardous) {
        this.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        this.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun ImageView.bindDetailsStatusImage( isHazardous: Boolean) {
    if (isHazardous) {
        this.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        this.setImageResource(R.drawable.asteroid_safe)
        }
}

@BindingAdapter("app:listData")
fun RecyclerView.bindRecyclerView(data: List<Asteroid>?) {
    val adapter = this.adapter as AsteroidAdapter
    adapter.setNewData(data)
}
@BindingAdapter("app:astronomicalUnitText")
fun TextView.bindTextViewToAstronomicalUnit( number: Double) {
    val context = this.context
    this.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("app:kmUnitText")
fun TextView.bindTextViewToKmUnit( number: Double) {
    val context = this.context
    this.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("app:velocityText")
fun TextView.bindTextViewToDisplayVelocity(number: Double) {
    val context = this.context
    this.text = String.format(context.getString(R.string.km_s_unit_format), number)
}
@BindingAdapter("app:isLoading")
fun ProgressBar.loading(isLoading:Boolean){
    this.isVisible = isLoading
}


