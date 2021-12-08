package com.schaefer.uishared.extensions

import android.content.Context
import android.widget.Toast

fun Context.toast(
    context: Context = applicationContext,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, message, duration).show()
}
