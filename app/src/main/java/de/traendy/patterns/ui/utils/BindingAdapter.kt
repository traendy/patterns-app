package de.traendy.patterns.ui.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import de.traendy.patterns.R

@BindingAdapter("imageRef")
fun imageRef(view: AppCompatImageView, value: String?) {
    if(value != null){
        val resources = view.context.resources
        val resourceId: Int = resources.getIdentifier(
            value, "drawable",
            view.context.packageName
        )
        view.setImageResource(resourceId)
    } else {
        view.setImageResource(R.drawable.nullobject)
    }
}