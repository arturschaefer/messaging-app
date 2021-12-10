package com.schaefer.useridentity.domain

import com.schaefer.useridentity.data.entity.UserEntity
import com.schaefer.useridentity.domain.model.User

internal fun UserEntity.toDomain(): User {
    return User(completeName = completeName, email = email, imageUrl = imageUrl)
}

internal fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.hashCode(),
        completeName = completeName,
        email = email,
        imageUrl = imageUrl
    )
}
