package de.traendy.patterns.ui.utils

import dagger.android.support.DaggerFragment
import de.traendy.patterns.MainActivity
import kotlinx.android.synthetic.main.main_activity.*

fun DaggerFragment.setMenu(menuRes: Int) {
    (activity as MainActivity).topAppBar.menu.clear()
    (activity as MainActivity).topAppBar.inflateMenu(menuRes)
}