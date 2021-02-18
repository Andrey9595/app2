
package com.onimus.blablasocialmedia.mvvm.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.onimus.blablasocialmedia.R
import kotlinx.android.synthetic.main.dialog_progressbar.*

class ProgressDialog(context: Context, private val resId: Int) : Dialog(context) {

    override fun create() {
        setCancelable(false)
        val view = View.inflate(context, R.layout.dialog_progressbar, null)
        setContentView(view)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        tvProgressDialog.text = context.getString(resId)

    }
}