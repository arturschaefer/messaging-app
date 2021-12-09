package com.schaefer.messagelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.schaefer.messagelist.domain.model.MessageText
import com.schaefer.messagelist.domain.model.User
import com.schaefer.messagelist.domain.repository.MessageRepository
import com.schaefer.messagelist.domain.repository.UserRepository
import com.schaefer.messagelist.presentation.model.MessageListVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Create a resource provider and use values from dimens
private const val BUTTON_ALPHA_DISABLED = 0.7f
private const val BUTTON_ALPHA_ENABLED = 1f

internal class MessageListViewModel(
    private val messageListVO: MessageListVO,
    private val messageRepository: MessageRepository,
    private val userRepository: UserRepository
) : ViewModel() {
    val messageList =
        messageRepository.getMessageList(messageListVO.chatId).asLiveData()

    private val messageListMock = listOf(
        MessageText(
            sendBy = "me",
            chatId = "1234",
            message = "Lorem Ipsum",
            time = System.currentTimeMillis(),
        ),
        MessageText(
            sendBy = "other",
            chatId = "1234",
            message = "Lorem Ipsum",
            time = System.currentTimeMillis(),
        ),
        MessageText(
            sendBy = "other",
            chatId = "1234",
            message = "Lorem Ipsum",
            time = System.currentTimeMillis(),
        ),
        MessageText(
            sendBy = "me",
            chatId = "1234",
            message = "It is a long established fact that a reader will be distracted",
            time = System.currentTimeMillis(),
        )
    )

    fun insertUsers() {
        val userList = listOf(
            User("User 1", "user1@test.com", ""),
            User("User 2", "user2@test.com", "")
        )
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.saveAllUsers(userList)
        }
    }

    // TODO pass the right userId
    fun sendMessage(chatId: String, message: String, sendBy: String = "me") {
        val messageText = MessageText(
            sendBy = sendBy,
            chatId = chatId,
            message = message,
            time = System.currentTimeMillis()
        )
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.sendMessage(messageText)
        }
    }

    fun sendMessages(): Boolean {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.sendAllMessages(messageListMock)
        }
        return true
    }

    fun validateEditText(text: String?): Pair<Boolean, Float> {
        return if (text.isNullOrEmpty()) {
            Pair(false, BUTTON_ALPHA_DISABLED)
        } else {
            Pair(true, BUTTON_ALPHA_ENABLED)
        }
    }
}
