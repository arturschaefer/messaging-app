package com.schaefer.messagelist.navigation

import android.content.Context
import androidx.core.os.bundleOf
import com.schaefer.messagelist.presentation.MessagingListActivity
import com.schaefer.navigation.MessagingListNavigation
import com.schaefer.navigation.extensions.openActivity

internal class MessagingListNavigationImpl() : MessagingListNavigation {
    override fun openMessagingList(context: Context) {
        context.openActivity(MessagingListActivity::class.java, bundleOf())
    }
}
