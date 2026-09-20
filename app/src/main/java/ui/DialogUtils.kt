package com.example.konklavtracer_v2.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.konklavtracer_v2.R

object DialogUtils {

    fun showDeleteDialog(
        context: Context,
        title: String,
        message: String,
        onConfirm: () -> Unit
    ) {
        val dialog = Dialog(context).apply {
            setContentView(R.layout.dialog_delet_confirmation)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.setDimAmount(0.7f)
            window?.setLayout(
                (context.resources.displayMetrics.widthPixels * 0.9).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            findViewById<TextView>(R.id.tvDeleteTitle).text = title
            findViewById<TextView>(R.id.tvDeleteMessage).text = message

            findViewById<Button>(R.id.btnCancelDelete).setOnClickListener {
                dismiss()
            }

            findViewById<Button>(R.id.btnConfirmDelete).setOnClickListener {
                onConfirm()
                dismiss()
            }
        }
        dialog.show()
    }
}