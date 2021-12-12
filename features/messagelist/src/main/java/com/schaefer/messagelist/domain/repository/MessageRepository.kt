package com.schaefer.messagelist.domain.repository

import com.schaefer.messagelist.domain.model.MessageText
import kotlinx.coroutines.flow.Flow

internal interface MessageRepository {
    fun getMessageList(chatId: String): Flow<List<MessageText>>
    fun sendMessage(messageText: MessageText)
    fun sendAllMessages(messageList: List<MessageText>)
}
