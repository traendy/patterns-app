package de.traendy.patterns.ui.utils

import dagger.android.support.DaggerFragment
import de.traendy.patterns.MainActivity
import de.traendy.patterns.R
import kotlinx.android.synthetic.main.main_activity.*

fun DaggerFragment.setMenu(menuRes: Int) {
    (activity as MainActivity).topAppBar.menu.clear()
    (activity as MainActivity).topAppBar.inflateMenu(menuRes)
}

fun DaggerFragment.setFavoriteIcon(isFavorite:Boolean) {
    if (isFavorite) {
        (activity as MainActivity).topAppBar.menu.findItem(R.id.favorite)
            .setIcon(R.drawable.ic_favorite_24dp)
    } else {
        (activity as MainActivity).topAppBar.menu.findItem(R.id.favorite)
            .setIcon(R.drawable.ic_favorite_border_24dp)
    }
}