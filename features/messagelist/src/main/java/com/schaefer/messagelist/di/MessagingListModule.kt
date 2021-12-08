package com.schaefer.messagelist.di

import com.schaefer.messagelist.navigation.MessagingListNavigationImpl
import com.schaefer.messagelist.presentation.MessagingListViewModel
import com.schaefer.navigation.MessagingListNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val messagingListModule = module {
    factory<MessagingListNavigation> { MessagingListNavigationImpl() }

    viewModel { MessagingListViewModel() }
}
