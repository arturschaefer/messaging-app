package com.schaefer.messagelist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.schaefer.messagelist.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(userList: List<UserEntity>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>
}
