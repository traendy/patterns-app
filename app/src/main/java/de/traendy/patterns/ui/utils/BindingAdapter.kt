package de.traendy.patterns.ui.utils

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import de.traendy.patterns.R

@BindingAdapter("imageRef")
fun imageRef(view: AppCompatImageView, value: Int?) {
    if(value != null){
        view.setImageResource(value)
    } else {
        view.setImageResource(R.drawable.nullobject)
    }
}