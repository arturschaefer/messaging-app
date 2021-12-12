package com.schaefer.messagelist.presentation.adapter.extensions

import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.schaefer.messagelist.R

internal fun TextView.formatDateToDayAndHour(time: Long) {
    val dayOfWeek = time.convertDayOfWeek()
    val hour = time.convertHourMinutes()
    text = HtmlCompat.fromHtml(
        String.format(
            resources.getString(R.string.message_day_hour),
            dayOfWeek,
            hour
        ),
        HtmlCompat.FROM_HTML_MODE_LEGACY
    )
}
