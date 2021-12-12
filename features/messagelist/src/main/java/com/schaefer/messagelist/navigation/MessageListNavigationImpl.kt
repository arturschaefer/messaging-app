package com.schaefer.messagelist.navigation

import android.content.Context
import android.os.Bundle
import com.schaefer.messagelist.presentation.MessageListActivity
import com.schaefer.navigation.MessageListNavigation
import com.schaefer.navigation.extensions.openActivity

internal class MessageListNavigationImpl : MessageListNavigation {
    override fun openMessageList(context: Context, bundle: Bundle) {
        context.openActivity(MessageListActivity::class.java, bundle)
    }
}
