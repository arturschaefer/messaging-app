package com.schaefer.messagelist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.schaefer.messagelist.data.entity.MessageTextEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface MessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessage(messageTextEntity: MessageTextEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMessages(messageList: List<MessageTextEntity>)

    @Query("SELECT * FROM messages WHERE chat_id = :chatId ORDER BY time ASC")
    fun getAll(chatId: String): Flow<List<MessageTextEntity>>
}
