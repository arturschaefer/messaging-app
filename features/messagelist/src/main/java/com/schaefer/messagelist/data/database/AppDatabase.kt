package com.schaefer.messagelist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.schaefer.messagelist.data.dao.MessageDao
import com.schaefer.messagelist.data.dao.UserDao
import com.schaefer.messagelist.data.entity.MessageTextEntity
import com.schaefer.messagelist.data.entity.UserEntity

@Database(
    entities = [UserEntity::class, MessageTextEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract val messageDao: MessageDao
    abstract val userDao: UserDao
}
