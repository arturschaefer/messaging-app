package com.schaefer.useridentity.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
internal data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "complete_name") val completeName: String,
    @ColumnInfo(name = "url_image") val imageUrl: String,
    val email: String,
)
