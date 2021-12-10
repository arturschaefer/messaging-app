package com.schaefer.messagelist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.schaefer.messagelist.data.dao.MessageDao
import com.schaefer.messagelist.data.entity.MessageTextEntity

@Database(
    entities = [MessageTextEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class MessageListDatabase : RoomDatabase() {
    abstract val messageDao: MessageDao
}
