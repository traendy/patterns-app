package de.traendy.patterns.ui.utils

import android.text.Editable
import android.text.TextWatcher

open class TextWatcherAdapter : TextWatcher {

    override fun afterTextChanged(editable: Editable?) { /* unused */ }

    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) { /* unused */
    }

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) { /* unused */
    }

}