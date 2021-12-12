package com.schaefer.messagelist.di

import android.content.Context
import androidx.room.Room
import com.schaefer.messagelist.data.dao.MessageDao
import com.schaefer.messagelist.data.database.MessageListDatabase
import com.schaefer.messagelist.data.repository.MessageRepositoryImpl
import com.schaefer.messagelist.domain.repository.MessageRepository
import com.schaefer.messagelist.navigation.MessageListNavigationImpl
import com.schaefer.messagelist.presentation.MessageListViewModel
import com.schaefer.messagelist.presentation.model.ChatInfoVO
import com.schaefer.messagelist.presentation.model.UserVO
import com.schaefer.navigation.MessageListNavigation
import org.jetbrains.annotations.VisibleForTesting
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.Locale

val messageListModule = module {
    fun provideDatabase(context: Context): MessageListDatabase {
        return Room.databaseBuilder(context, MessageListDatabase::class.java, "messaging-app")
            .build()
    }

    fun provideMessageDao(database: MessageListDatabase): MessageDao = database.messageDao

    single { provideDatabase(androidContext()) }
    single { provideMessageDao(get()) }

    factory<MessageRepository> { MessageRepositoryImpl(messageDao = get()) }

    factory<MessageListNavigation> { MessageListNavigationImpl() }

    viewModel { params ->
        MessageListViewModel(
            chatInfoVO = params.get(),
            messageRepository = get(),
        )
    }

    factory<Locale> { Locale.getDefault() }
}

// TODO this was necessary to override MessageListViewModel without params while testing
// TODO would be better move it to a different file
@VisibleForTesting
val messageListModuleTest = module {
    viewModel {
        MessageListViewModel(
            chatInfoVO = ChatInfoVO(
                chatId = "f1ad1f33a32e609250ecc006dca617da",
                sendByUserId = "723c4a9ca31c8016f44e59a459516cb4",
                sendTo = UserVO("", "", "")
            ),
            messageRepository = get(),
        )
    }
}
