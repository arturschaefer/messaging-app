package com.schaefer.messagelist.presentation.adapter.viewholder

import androidx.core.view.isVisible
import com.schaefer.messagelist.R
import com.schaefer.messagelist.databinding.MessagingListItemMessageSendBinding
import com.schaefer.messagelist.domain.model.MessageStatus
import com.schaefer.messagelist.domain.model.MessageText

internal class MessageSendViewHolder(
    private val binding: MessagingListItemMessageSendBinding
) : MessageViewHolder(binding) {

    override fun bind(message: MessageText) {
        binding.textViewMessage.text = message.message
        when (message.messageStatus) {
            MessageStatus.ERROR -> {
                binding.imageViewMessageStatus.apply {
                    isVisible = true
                    setImageResource(R.drawable.ic_error_24)
                }
            }
            MessageStatus.SENT -> {
                binding.imageViewMessageStatus.apply {
                    isVisible = true
                    setImageResource(R.drawable.ic_check_24)
                }
            }
            MessageStatus.DELIVERED -> {
                binding.imageViewMessageStatus.apply {
                    isVisible = true
                    setImageResource(R.drawable.ic_delivered_24)
                }
            }
            MessageStatus.READ -> {
                binding.imageViewMessageStatus.apply {
                    isVisible = true
                    setImageResource(R.drawable.ic_done_all_24)
                }
            }
            MessageStatus.HIDDEN, null -> {
                binding.imageViewMessageStatus.isVisible = false
            }
        }
    }
}
