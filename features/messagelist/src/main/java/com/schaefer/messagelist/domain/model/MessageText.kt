package com.schaefer.messagelist.domain.model

internal data class MessageText(
    val sendBy: String,
    val message: String,
    val utcTime: String,
    val messageStatus: MessageStatus = MessageStatus.HIDDEN
)
