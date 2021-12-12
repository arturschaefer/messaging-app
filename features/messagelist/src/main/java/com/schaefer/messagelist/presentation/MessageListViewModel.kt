package com.schaefer.messagelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.schaefer.messagelist.domain.model.MessageText
import com.schaefer.messagelist.domain.repository.MessageRepository
import com.schaefer.messagelist.presentation.model.ChatInfoVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Create a resource provider and use values from dimens
private const val BUTTON_ALPHA_DISABLED = 0.7f
private const val BUTTON_ALPHA_ENABLED = 1f

internal class MessageListViewModel(
    private val chatInfoVO: ChatInfoVO,
    private val messageRepository: MessageRepository,
) : ViewModel() {
    val messageList =
        messageRepository.getMessageList(chatInfoVO.chatId).asLiveData()

    fun sendMessage(message: String) {
        val messageText = MessageText(
            sendBy = chatInfoVO.sendByUserId,
            chatId = chatInfoVO.chatId,
            message = message,
            time = System.currentTimeMillis()
        )
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.sendMessage(messageText)
        }
    }

    fun validateEditText(text: String?): Pair<Boolean, Float> {
        return if (text.isNullOrEmpty()) {
            Pair(false, BUTTON_ALPHA_DISABLED)
        } else {
            Pair(true, BUTTON_ALPHA_ENABLED)
        }
    }
}
