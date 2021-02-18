

package com.onimus.blablasocialmedia.mvvm.utils

import com.google.android.material.textfield.TextInputLayout

fun sendActionToTextInputLayout(message: String, textInputLayout: TextInputLayout) {
    textInputLayout.let {
        it.error = message
        it.requestFocus()
        it.isFocusable = true
    }
}