package com.schaefer.navigation.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle

fun <T> Context.openActivity(activityClass: Class<T>, extras: Bundle? = null) {
    val intent = Intent(this, activityClass).apply {
        extras?.let {
            this.putExtras(extras)
        }
    }
    startActivity(intent)
}
