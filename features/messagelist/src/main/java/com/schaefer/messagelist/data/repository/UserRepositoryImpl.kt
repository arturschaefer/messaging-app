package com.schaefer.messagelist.data.repository

import com.schaefer.messagelist.data.dao.UserDao
import com.schaefer.messagelist.domain.mapper.toDomain
import com.schaefer.messagelist.domain.mapper.toEntity
import com.schaefer.messagelist.domain.model.User
import com.schaefer.messagelist.domain.repository.UserRepository
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
