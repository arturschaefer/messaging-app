package com.schaefer.messagelist.presentation.adapter.viewholder

import androidx.core.view.isVisible
import com.schaefer.messagelist.databinding.MessagingListItemMessageReceiveBinding
import com.schaefer.messagelist.domain.model.MessageText
import com.schaefer.messagelist.presentation.adapter.extensions.formatDateToDayAndHour

internal class MessageReceiveViewHolder(
    private val binding: MessagingListItemMessageReceiveBinding
) : MessageViewHolder(binding) {

    override fun bind(message: MessageText, hasTimeVisible: Boolean) {
        binding.textViewMessage.text = message.message
        if (hasTimeVisible) {
            binding.textViewDayHour.apply {
                formatDateToDayAndHour(message.time)
                isVisible = hasTimeVisible
            }
        }
    }
}
