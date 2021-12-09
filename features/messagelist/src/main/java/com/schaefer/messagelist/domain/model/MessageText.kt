package com.schaefer.messagelist.domain.model

internal data class MessageText(
    val sendBy: String,
    val chatId: String,
    val message: String,
    val time: Long,
    val messageStatus: MessageStatus? = MessageStatus.HIDDEN
)
