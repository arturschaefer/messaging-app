package com.schaefer.messagelist.domain.mapper

import com.schaefer.messagelist.data.entity.MessageTextEntity
import com.schaefer.messagelist.domain.model.MessageText

// TODO change message status
internal fun MessageTextEntity.toDomain(): MessageText {
    return MessageText(
        sendBy = sendBy,
        chatId = chatId,
        message = message,
        time = time,
        messageStatus = null
    )
}

internal fun MessageText.toEntity(): MessageTextEntity {
    return MessageTextEntity(
        sendBy = sendBy,
        chatId = chatId,
        messageStatus = messageStatus?.name.orEmpty(),
        message = message,
        time = time
    )
}
