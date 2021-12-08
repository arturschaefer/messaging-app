package com.schaefer.messagelist.presentation.adapter.viewholder

import androidx.core.view.isVisible
import com.schaefer.messagelist.databinding.MessagingListItemMessageSendBinding
import com.schaefer.messagelist.domain.model.MessageStatus
import com.schaefer.messagelist.domain.model.MessageText

internal class MessageSendViewHolder(
    private val binding: MessagingListItemMessageSendBinding
) : MessageViewHolder(binding) {

    override fun bind(message: MessageText) {
        binding.textViewMessage.text = message.message
        // TODO create image resources to read status
        // TODO put Glide to load it
        when (message.messageStatus) {
            MessageStatus.HIDDEN -> {
                binding.imageViewMessageStatus.isVisible = false
            }
            MessageStatus.ERROR -> {}
            MessageStatus.SENT -> {}
            MessageStatus.DELIVERED -> {}
            MessageStatus.READ -> {}
        }
        // binding.imageViewMessageStatus
    }
}
