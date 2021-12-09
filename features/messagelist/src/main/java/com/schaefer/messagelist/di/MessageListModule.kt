package com.schaefer.messagelist.di

import android.content.Context
import androidx.room.Room
import com.schaefer.messagelist.data.dao.MessageDao
import com.schaefer.messagelist.data.dao.UserDao
import com.schaefer.messagelist.data.database.AppDatabase
import com.schaefer.messagelist.data.repository.MessageRepositoryImpl
import com.schaefer.messagelist.data.repository.UserRepositoryImpl
import com.schaefer.messagelist.domain.repository.MessageRepository
import com.schaefer.messagelist.domain.repository.UserRepository
import com.schaefer.messagelist.navigation.MessageListNavigationImpl
import com.schaefer.messagelist.presentation.MessageListViewModel
import com.schaefer.messagelist.presentation.model.MessageListVO
import com.schaefer.navigation.MessageListNavigation
import org.jetbrains.annotations.VisibleForTesting
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val messageListModule = module {
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "messaging-app")
            .build()
    }

    fun provideMessageDao(database: AppDatabase): MessageDao = database.messageDao
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao

    single { provideDatabase(androidContext()) }
    single { provideMessageDao(get()) }
    single { provideUserDao(get()) }

    factory<MessageRepository> { MessageRepositoryImpl(messageDao = get()) }
    factory<UserRepository> { UserRepositoryImpl(userDao = get()) }

    factory<MessageListNavigation> { MessageListNavigationImpl() }

    viewModel { params ->
        MessageListViewModel(
            messageListVO = params.get(),
            userRepository = get(),
            messageRepository = get(),
        )
    }
}

// TODO this was necessary to override MessageListViewModel without params while testing
@VisibleForTesting
val messageListModuleTest = module {
    viewModel {
        MessageListViewModel(
            messageListVO = MessageListVO(""),
            userRepository = get(),
            messageRepository = get(),
        )
    }
}
