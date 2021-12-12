package com.schaefer.messagelist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
internal data class MessageTextEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "send_by") val sendBy: String,
    @ColumnInfo(name = "chat_id") val chatId: String,
    @ColumnInfo(name = "message_status") val messageStatus: String?,
    val message: String,
    val time: Long
)
