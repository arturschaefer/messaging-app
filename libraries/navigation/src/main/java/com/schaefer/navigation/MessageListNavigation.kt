package com.schaefer.navigation

import android.content.Context
import android.os.Bundle

const val BUNDLE_MESSAGE_LIST = "message_list"

interface MessageListNavigation {
    fun openMessageList(context: Context, bundle: Bundle = Bundle())
}
