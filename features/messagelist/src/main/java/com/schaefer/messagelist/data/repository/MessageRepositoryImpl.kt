package com.schaefer.messagelist.data.repository

import com.schaefer.messagelist.data.dao.MessageDao
import com.schaefer.messagelist.domain.mapper.toDomain
import com.schaefer.messagelist.domain.mapper.toEntity
import com.schaefer.messagelist.domain.model.MessageText
import com.schaefer.messagelist.domain.repository.MessageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MessageRepositoryImpl(private val messageDao: MessageDao) : MessageRepository {
    override fun getMessageList(chatId: String): Flow<List<MessageText>> {
        return messageDao.getAll(chatId).map { list -> list.map { it.toDomain() } }
    }

    override fun sendMessage(messageText: MessageText) {
        messageDao.insertMessage(messageText.toEntity())
    }

    override fun sendAllMessages(messageList: List<MessageText>) {
        messageDao.insertAllMessages(messageList.map { it.toEntity() })
    }
}
