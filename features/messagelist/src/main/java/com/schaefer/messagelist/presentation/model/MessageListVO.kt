package com.schaefer.messagelist.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageListVO(val chatId: String) : Parcelable
