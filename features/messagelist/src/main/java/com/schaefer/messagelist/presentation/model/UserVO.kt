package com.schaefer.messagelist.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserVO(val userId: String, val firstName: String, val imageUrl: String) : Parcelable
