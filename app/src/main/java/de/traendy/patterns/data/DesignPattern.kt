package de.traendy.patterns.data


import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class DesignPattern(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val thumb: Bitmap? = null,
    val structure: Bitmap? = null
)