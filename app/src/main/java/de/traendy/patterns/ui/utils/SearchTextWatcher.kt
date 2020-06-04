package de.traendy.patterns.ui.utils

import android.text.Editable

class SearchTextWatcher(private val callback: (String) -> Unit) : TextWatcherAdapter() {

    override fun afterTextChanged(editable: Editable?) {
        callback(editable.toString())
        super.afterTextChanged(editable)
    }

}