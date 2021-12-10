package com.schaefer.useridentity.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.schaefer.useridentity.data.dao.UserDao
import com.schaefer.useridentity.data.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class UserIdentityDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}
