package com.schaefer.messagelist.domain.mapper

import com.schaefer.messagelist.data.entity.UserEntity
import com.schaefer.messagelist.domain.model.User

internal fun UserEntity.toDomain(): User {
    return User(completeName = completeName, email = email)
}

internal fun User.toEntity(): UserEntity {
    return UserEntity(id = this.hashCode(), completeName = completeName, email = email)
}
