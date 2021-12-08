package com.schaefer.messagelist.presentation

import androidx.lifecycle.ViewModel
import com.schaefer.messagelist.domain.model.MessageText

internal class MessageListViewModel : ViewModel() {

    fun getMessageList(): List<MessageText> {
        return arrayListOf(
            MessageText(
                sendBy = "me",
                message = "Lorem Ipsum",
                utcTime = System.nanoTime().toString(),
            ),
            MessageText(
                sendBy = "other",
                message = "Lorem Ipsum",
                utcTime = System.nanoTime().toString(),
            ),
            MessageText(
                sendBy = "other",
                message = "Lorem Ipsum",
                utcTime = System.nanoTime().toString(),
            ),
            MessageText(
                sendBy = "other",
                message = "Lorem Ipsum is simply dummy text",
                utcTime = System.nanoTime().toString(),
            ),
            MessageText(
                sendBy = "me",
                message = "It is a long established fact that a reader will be distracted",
                utcTime = System.nanoTime().toString(),
            )
        )
    }
}
