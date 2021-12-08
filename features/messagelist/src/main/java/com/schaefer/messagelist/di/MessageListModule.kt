package com.schaefer.messagelist.di

import com.schaefer.messagelist.navigation.MessageListNavigationImpl
import com.schaefer.messagelist.presentation.MessageListViewModel
import com.schaefer.navigation.MessageListNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val messageListModule = module {
    factory<MessageListNavigation> { MessageListNavigationImpl() }

    viewModel { MessageListViewModel() }
}
