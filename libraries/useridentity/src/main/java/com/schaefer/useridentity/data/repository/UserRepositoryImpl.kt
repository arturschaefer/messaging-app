package com.schaefer.useridentity.data.repository

import com.schaefer.useridentity.data.dao.UserDao
import com.schaefer.useridentity.domain.model.User
import com.schaefer.useridentity.domain.repository.UserRepository
import com.schaefer.useridentity.domain.toDomain
import com.schaefer.useridentity.domain.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return userDao.getAllUsers().map { list -> list.map { it.toDomain() } }
    }

    override fun saveUser(user: User) {
        userDao.insertUser(user.toEntity())
    }

    override fun saveAllUsers(users: List<User>) {
        userDao.insertAllUsers(users.map { it.toEntity() })
    }
}
