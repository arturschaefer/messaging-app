package com.schaefer.useridentity.domain.repository

import com.schaefer.useridentity.domain.model.User
import kotlinx.coroutines.flow.Flow

internal interface UserRepository {
    fun getUsers(): Flow<List<User>>
    fun saveUser(user: User)
    fun saveAllUsers(users: List<User>)
}
