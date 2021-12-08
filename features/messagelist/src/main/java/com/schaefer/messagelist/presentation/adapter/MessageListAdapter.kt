package com.schaefer.messagelist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.messagelist.databinding.MessagingListItemMessageReceiveBinding
import com.schaefer.messagelist.databinding.MessagingListItemMessageSendBinding
import com.schaefer.messagelist.domain.model.MessageText
import com.schaefer.messagelist.presentation.adapter.viewholder.MessageReceiveViewHolder
import com.schaefer.messagelist.presentation.adapter.viewholder.MessageSendViewHolder
import com.schaefer.messagelist.presentation.adapter.viewholder.MessageViewHolder

private const val VIEW_TYPE_MESSAGE_SEND = 1
private const val VIEW_TYPE_MESSAGE_RECEIVE = 2

internal class MessageListAdapter : RecyclerView.Adapter<MessageViewHolder>() {

    var messageList = emptyList<MessageText>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                MessageListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun getItemCount(): Int = messageList.size

    override fun getItemViewType(position: Int): Int {
        val message = messageList[position]

        // TODO pass logged user id
        return if ("me" == message.sendBy) {
            VIEW_TYPE_MESSAGE_SEND
        } else {
            VIEW_TYPE_MESSAGE_RECEIVE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return when (viewType) {
            VIEW_TYPE_MESSAGE_SEND -> {
                MessageSendViewHolder(
                    MessagingListItemMessageSendBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            else -> {
                MessageReceiveViewHolder(
                    MessagingListItemMessageReceiveBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        holder.bind(message)
    }
}