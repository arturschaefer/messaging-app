package com.schaefer.messagelist.navigation

import android.content.Context
import androidx.core.os.bundleOf
import com.schaefer.messagelist.presentation.MessageListActivity
import com.schaefer.navigation.MessageListNavigation
import com.schaefer.navigation.extensions.openActivity

internal class MessageListNavigationImpl() : MessageListNavigation {
    override fun openMessageList(context: Context) {
        context.openActivity(MessageListActivity::class.java, bundleOf())
    }
}
