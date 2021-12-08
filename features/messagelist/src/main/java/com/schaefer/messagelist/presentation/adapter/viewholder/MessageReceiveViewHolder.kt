package com.schaefer.messagelist.presentation.adapter.viewholder

import com.schaefer.messagelist.databinding.MessagingListItemMessageReceiveBinding
import com.schaefer.messagelist.domain.model.MessageText

internal class MessageReceiveViewHolder(
    private val binding: MessagingListItemMessageReceiveBinding
) : MessageViewHolder(binding) {

    override fun bind(message: MessageText) {
        binding.textViewMessage.text = message.message
    }
}
