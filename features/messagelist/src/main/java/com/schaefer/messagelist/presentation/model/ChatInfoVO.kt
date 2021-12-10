package com.schaefer.messagelist.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatInfoVO(
    val chatId: String,
    val sendByUserId: String,
    val sendTo: UserVO
) : Parcelable
