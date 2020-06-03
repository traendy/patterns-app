package de.traendy.patterns.data


import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class DesignPattern(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val thumb: Int? = null,
    val structure: Int? = null
)