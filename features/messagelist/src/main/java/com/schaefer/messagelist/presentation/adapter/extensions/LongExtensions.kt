package com.schaefer.messagelist.presentation.adapter.extensions

internal fun Long.millisecondsToHours(): Int {
    return runCatching { ((this / (1000 * 60 * 60)) % 24).toInt() }.getOrElse { 0 }
}
