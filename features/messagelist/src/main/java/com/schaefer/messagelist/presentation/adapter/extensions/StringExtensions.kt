package com.schaefer.messagelist.presentation.adapter.extensions

import org.koin.java.KoinJavaComponent.inject
import java.text.SimpleDateFormat
import java.util.Locale

private const val DATE_FORMAT_DAY_OF_WEEK = "EEEE"
private const val DATE_FORMAT_HOUR_MINUTES = "HH:mm"
private val locale: Locale by inject(Locale::class.java)
private val simpleFormatDateDayOfWeek: SimpleDateFormat by lazy {
    SimpleDateFormat(DATE_FORMAT_DAY_OF_WEEK, locale)
}
private val simpleFormatHourMinutes: SimpleDateFormat by lazy {
    SimpleDateFormat(DATE_FORMAT_HOUR_MINUTES, locale)
}

internal fun Long.convertDayOfWeek(): String {
    return runCatching { simpleFormatDateDayOfWeek.format(this) }.getOrElse { "" }
}

internal fun Long.convertHourMinutes(): String {
    return runCatching { simpleFormatHourMinutes.format(this) }.getOrElse { "" }
}
